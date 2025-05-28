package Recursion;

public class CountNoOfStepsToZero {

	public static void main(String[] args) {
		System.out.println(noOfSteps(14));
}
	
	static int noOfSteps(int n) {
		return helper(n,0);
	}
	static int helper(int n, int count) {
		if(n == 0) {
			return count;
		}
	 return n %2 ==0 ? helper(n/2, count +1): helper(n-1, count+1);
	}
}
