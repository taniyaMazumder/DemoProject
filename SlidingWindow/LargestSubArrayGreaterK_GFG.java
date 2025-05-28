// Length of longest subarray in which elements greater than K are more than elements not greater than K

package SlidingWindow;

public class LargestSubArrayGreaterK_GFG {

	public static void main(String[] args) {
		int[] a= {1, 2, 3, 4, 1};
		int k=2;
		System.out.println(longestSubarray2(a,a.length,k));

	}
// Brute Force- TC- O(n^3), SC- O(1)
	static int longestSubarray(int a[], int n, int k) {
		int ans=0;
		for(int i=0;i<n;i++) {
			for (int j = i; j < n; j++) {
				int grCount =0;
				int lessEqCount =0;
				for (int l = j; l < n; l++) {
					if(a[l] >k) {
						grCount++;
					} else {
						lessEqCount++;
					}
				}	
					if(grCount > lessEqCount) {
						ans = Math.max(ans, j-i+1);
					}
				
			}
		}
		return ans;
	}
	
	// Optimize -TC-O(N^2)
	static int longestSubarray2(int a[], int n, int k) {
		int ans=0;
		for(int i=0;i<n;i++) {
			int grCount =0;
			int lessEqCount =0;
			for (int j = i; j < n; j++) {
				if(a[j] >k) {
						grCount++;
					} else {
						lessEqCount++;
					}
					
					if(grCount > lessEqCount) {
						ans = Math.max(ans, j-i+1);
					}
				
			}
		}
		return ans;
	}
}
