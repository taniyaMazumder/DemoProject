package DynamicProgramming;

public class MinNoOfCoinChange {

	
	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int sum = 5;
		System.out.println(minNoOfCoinChange(coins, sum));
	}
	public static int minNoOfCoinChange(int[] coins, int sum) {
		int n = coins.length;
       
		int[][] t = new int[n+1][sum+1];
		
		// initialize 0th row
				
		// initialize 0th col
		for (int i = 0; i < n +1; i++) {
			for (int j = 0; j < sum +1; j++) {
				//0th row and 0th col initilization 
	            if(j == 0){t[i][j] = 0;}
	            if(i == 0){t[i][j] = Integer.MAX_VALUE-1;}
	            
	          //1st ROW INITILIZTION
	            if(i == 1 && j>0)
	            {
	            	if(j % coins[0] ==0) {
						t[i][j] = j/ coins[0];
					}
					else {
						t[i][j] = Integer.MAX_VALUE -1;
					}
	            }
			}
		}
		
		// starting from 2nd row
		for (int i = 2; i < n+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if(coins[i-1] <=j) {
					t[i][j] =  Math.min(t[i][j - coins[i-1]] +1, t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		if(t[n][sum]==Integer.MAX_VALUE-1){return -1;}
		
		return t[n][sum];
	}
}
