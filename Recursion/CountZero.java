package Recursion;

public class CountZero {

	public static void main(String[] args) {
		System.out.println(countZero(3020405));
	}
	
	static int countZero(int n) {

		return helper(n,0);
	}

	static int helper(int n, int count) {
		if(n ==0) {
			return count;
		}
	/*	if(n%10 ==0) {
			return helper(n/10,count+1);
		}
		else {
			return helper(n/10,count);
		}
		*/
		return n%10 ==0 ? helper(n/10,count+1) : helper(n/10,count);
	}
}
