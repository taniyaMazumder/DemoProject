package LinearSearch;

public class FindMaxIn2DArray {

	public static void main(String[] args) {
		int[][] ar = {
				{1,2,3},
				{9,1,6},
				{3,3,7}
		};
		System.out.println(maxWealth(ar));
	}
	public static int maxWealth(int[][] accounts) {
		
		int max = Integer.MIN_VALUE;
		for (int row = 0; row < accounts.length; row++) {
			int sum =0;
			for (int col = 0; col < accounts[row].length; col++) {
				sum = sum+ accounts[row][col];
			}
			max = Math.max(max, sum);
		}
		
		return max;
	}

}
