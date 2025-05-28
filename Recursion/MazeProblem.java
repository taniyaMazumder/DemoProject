package Recursion;

public class MazeProblem {

	public static void main(String[] args) {
		System.out.println(mazeCountPath(3,3));
		printPathDiag("",3,3);
		

	}
	static int mazeCountPath(int row, int col) {
		if( row ==1 || col ==1) {
			return 1;
		}
		int left = mazeCountPath(row -1, col);
		int right = mazeCountPath(row , col -1);
		
		return left + right;
	}

	// print paths
	static void printPath(String p, int row, int col) {
		if(row == 1 && col ==1) {
			System.out.println(p);
			return;
		}
		if(row >1) {
			printPath(p + 'D', row -1, col);
		}
		if(col >1) {
			printPath(p + 'R', row , col -1);
		}
		
	}
	
	// print paths diagonal also
		static void printPathDiag(String p, int row, int col) {
			if(row == 1 && col ==1) {
				System.out.println(p);
				return;
			}
			if(row >1) {
				printPathDiag(p + 'V', row -1, col);
			}
			if(col >1) {
				printPathDiag(p + 'H', row , col -1);
			}
			if(row > 1 && col >1) {
				printPathDiag(p + 'D', row -1, col -1);
			}
		}
}
