package DynamicProgramming;

public class EqualSumPartition {

	public static void main(String[] args) {
		int[] arr= {4, 3, 2, 1};
		System.out.println(equalSumPartitionRec(arr));

	}
	
	static boolean equalSumPartition(int[] arr) {
		int sum =0;
		for(int i=0;i< arr.length;i++) {
			sum =sum + arr[i];
		}
		if(sum % 2 !=0) {
			return false;
		}
		
		return helper(arr, sum/2, arr.length -1);
	}

	public static boolean helper(int[] arr, int sum, int n) {
		boolean[][] t = new boolean[arr.length +1][sum +1];
		
		//initialization true and false
        for(int i = 0; i<sum+1; i++)
        {
        	t[0][i] = false;
        }
        
        for(int i = 0; i<n+1; i++)
        {
        	t[i][0] = true;
        }
        
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if(arr[i-1] <=j) {
					t[i][j] = t[i-1] [j - arr[i-1]] ||  t[i-1][j];
				}else  {
					t[i][j] = t[i-1][j];
				} 
			}
		}
		return t[n][sum];
	} 
	/*
	 * --------------------------------------------------------------------------------------------------------------------
	 * Using recursion
	 */
	public static boolean equalSumPartitionRec(int arr[]) {
        int sum =0;
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
        }
        if(sum %2 ==0){
            return helper2(arr, arr.length-1,sum/2);
        }
        else {
            return false;
        }
    }
    static boolean helper2(int[] arr, int n, int sum){
        // base condition
        if(n >=0 && sum ==0) {
			return true;
		}
		else if(n==0 && sum >0) {
			return false;
		}
        else if(arr[n-1] <=sum){
            return helper2(arr,n-1,sum- arr[n-1]) || helper2(arr,n-1,sum);
        } else {
            return helper2(arr,n-1,sum);
        }
    }
}
