package array;

public class RichestWealth {

	public static void main(String[] args) {
		int[][] nums = {{1,2,3},{3,2,1}};
		System.out.println(maximumWealth(nums));
	}

	public static int maximumWealth(int[][] accounts) {
		int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
        	int sum =0;
    		for (int j = 0; j < accounts[i].length; j++) {
				sum = sum + accounts[i][j];
			}
			if(sum > max) {
				 max = sum;
			}
		}
        
        
        return max;
    }
}
