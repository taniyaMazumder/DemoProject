// merge two array
//Intuition 1- Insert all the elements from nums2 to nums1 and sort
//Intuition 2- Two Pointer- Make i start from end of the element of nums1, Take j starts from end of the element of nums2
//and take k starts from end of the element of nums1 till .
package array;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = {7,8,9,0,0,0};
		int m = 3, n = 3;
		int[] nums2 = {2,5,6};
	 
		merge(nums1, m,nums2, n);
		System.out.println("Final Array is:" +Arrays.toString(nums1));
	}

	//Intuition-1
/*	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i=m; j < n; j++) {
			nums1[i] = nums2[j];
			i++;
		}
        Arrays.sort(nums1);
  }
  */
	//Intuition-2
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
