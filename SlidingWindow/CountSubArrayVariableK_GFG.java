package SlidingWindow;

public class CountSubArrayVariableK_GFG {

	public static void main(String[] args) {
		int[] ar= {3, 2, 1};
		int n = ar.length;
		int k=2;
		System.out.println(countSubarray(ar,n,k));

	}

	static long countSubarray(int arr[], int n, int k) {

		int maxElement = 0; // Variable to store the maximum element encountered so far 
        int count = 0;      // Variable to count the length of the sub-array with elements <= k 
        int ans = 0;        // Variable to store the final result 
  
        for (int i = 0; i < n; i++) { 
            if (arr[i] > maxElement) { 
                // If the current element is greater than the maximum element 
                // update the maximum element and reset the count to zero. 
                maxElement = arr[i]; 
                count = 0; 
            } else { 
                // increment the count 
                count++; 
            } 
  
            if (maxElement > k) { 
                // If the maximum element in the current subarray is greater than k, 
                // add the count of subarrays ending at the current index (i - count + 1) to the result. 
                ans += (i - count + 1); 
  
                // Reset the maximum element and count to zero. 
                maxElement = arr[i]; 
                count = 0; 
            } 
        } 
  
        // Return the final result 
        return ans;
   }
	
	
}
