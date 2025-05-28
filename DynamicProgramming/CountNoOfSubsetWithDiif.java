package DynamicProgramming;

public class CountNoOfSubsetWithDiif {

	public static void main(String[] args) {
		int[] arr = {1,1,2,3};
		int diff =1;
		
		System.out.println(countOfSubsetDiff(arr, diff, arr.length));

	}
	static int countOfSubsetDiff(int[] arr, int diff, int n) {
		// find sum of the array
		int sum =0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int actualSum = (sum + diff) /2;
		
		int[][] t = new int[arr.length +1][actualSum +1];
		//initialization 0 and 1
        for(int i = 0; i<actualSum+1; i++)
        {
        	t[0][i] = 0;
        }
       for(int i = 0; i<n+1; i++)
        {
        	t[i][0] = 1;
        }
        for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < actualSum+1; j++) {
				if(arr[i-1] <=j) {
					t[i][j] = t[i-1] [j - arr[i-1]] +  t[i-1][j];
				} else  {
					t[i][j] = t[i-1][j];
				} 
			}
		}
		return t[n][actualSum];
	}

}
