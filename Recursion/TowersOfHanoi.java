package Recursion;

public class TowersOfHanoi {

	public static void main(String[] args) {
		int N= 2;
	//	int s=1, h=2,d=3;
	//	solve('A','C','B',N);
		//solve(s,d,h,N);
		
		System.out.println();
		count('A','C','B',N,0);
	}

	private static void solve(char s, char d, char h,int n) {
		// base condition
		if(n == 1) {
			System.out.println("disk transfer from s:"+s+ " to d " +d);
			return;
		}
		solve(s,h,d,n-1);
		System.out.println("disk transfer from s:"+s+ " to d " +d); // last one nth disk move from s to d
		solve(h,d,s,n-1);
		System.out.println("disk transfer from h:" +h+ " to d "+d);
		
	}

	// count how many steps to transfer
	private static void count(char s, char d, char h,int n, int count) {
		// base condition
		if(n == 1) {
			System.out.println("disk transfer from s:"+s+ " to d " +d);
			return;
		}
		count(s,h,d,n-1,count++);
		System.out.println("disk transfer from s:"+s+ " to d " +d); // last one nth disk move from s to d
		count(h,d,s,n-1,count++);
		System.out.println("disk transfer from h:" +h+ " to d "+d);
		
	}
}
