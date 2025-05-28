package DynamicProgramming;

public class CountOfSubsetSum {

	public static void main(String[] args) {
			int[] arr= {2,3,5};
			int sum = 5;
//			int[] arr= {5, 2, 3, 10, 6, 8};
//			int sum = 10;
			System.out.println(countOfSubset(arr,sum));

	}
	static int countOfSubset(int[] arr, int sum) {
		return helper(arr, sum, arr.length );
	}
	public static int helper(int[] arr, int sum, int n) {
		int[][] t = new int[arr.length +1][sum +1];
		//initialization 0 and 1
        for(int i = 0; i<sum+1; i++)
        {
        	t[0][i] = 0;
        }
       for(int i = 0; i<n+1; i++)
        {
        	t[i][0] = 1;
        }
        for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if(arr[i-1] <=j) {
					t[i][j] = t[i-1] [j - arr[i-1]] +  t[i-1][j];
				} else  {
					t[i][j] = t[i-1][j];
				} 
			}
		}
		return t[n][sum];
	} 

}
