package DynamicProgramming;

public class TargetSum {

	public static void main(String[] args) {
		//int[] arr = {1,1,2,3};
		int[] arr = {0,0,0,0,0,0,0,0,1};
		int sum =1;
		
		System.out.println(findCountTargetSum(arr, sum, arr.length));

	}

	static int findCountTargetSum(int[] arr, int targetSum, int n) {
		// find array sum
		int sum =0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		/*
		int actualSum = (sum + targetSum)/2;
		
		//adding conditions: if sum < target and when sum + target is odd then return 0;
        if(sum < targetSum || (sum + targetSum) % 2 != 0){return 0;}
        actualSum= Math.abs(actualSum);
        */
		int actualSum = (sum - targetSum)/2;
		if(((sum - targetSum) % 2 == 1) || (targetSum > sum))
            return 0;
		
      //USE COUNT THE NUMBER OF SUBSET WITH THE GIVEN DIFFERENCE == w
		
		int[][] t = new int[n +1][actualSum +1];
		
		// initialize 0 and 1
		// initialize 0th row
		for (int i = 0; i < n +1; i++) {
			t[0][i] = 0;
		}
		// initialize 0th col
		for (int i = 0; i < actualSum +1; i++) {
			t[i][0] = 1;
		}
		
		for(int i=1; i < n+1;i++) {
			for(int j=1; j< actualSum +1;j++) {
				if(arr[i-1] <=j) {
					t[i][j] = t[i -1][j - arr[i-1]] + t[i-1][j];
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][actualSum];
	}
}
