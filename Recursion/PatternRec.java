package Recursion;

public class PatternRec {

	public static void main(String[] args) {
		printTriangle(4 , 0);
	}
	static void printPattern(int row, int col) {
		// Base condition
		if(row== 0) {
			return;
		}
		if(col < row) {
			System.out.print("*");
			printPattern(row , col+1);
		}
		else {
			System.out.println();
			printPattern(row -1 , 0);
		}
		
	}
	static void printTriangle(int row, int col) {
		// Base condition
		if(row == 0) {
			return;
		}
		if(col < row) {
			printTriangle(row , col+1);
			System.out.print("*");
		}
		else {
			printTriangle(row -1 , 0);
			System.out.println();
			
		}
		
	}

}
