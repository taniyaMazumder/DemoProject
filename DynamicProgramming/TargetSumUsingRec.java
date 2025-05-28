package DynamicProgramming;

public class TargetSumUsingRec {

	public static void main(String[] args) {
		int[] arr = {1,1,2,3};
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
		if(((sum - targetSum) % 2 == 1) || (targetSum > sum)) {
			 return 0;
		}
           
        return helper(arr, actualSum,n);
	}
        
      private static int helper(int[] arr, int actualSum,int n) {
    	  if(n ==0 && actualSum>0) {
              return 0;
          }
    	  if(n ==0 && actualSum==0) {
              return 1;
          }
          if(n>0 && actualSum==0) {
              return 1;
          }
          if(arr[n-1] <= actualSum) {
              return helper(arr, actualSum - arr[n-1], n-1) + helper(arr, actualSum, n-1);
          } else {
        	  return helper(arr, actualSum, n-1);
          }
          
	}

}
