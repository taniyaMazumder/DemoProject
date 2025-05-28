package Recursion;

import java.util.Arrays;

public class QuickSortRec {

	public static void main(String[] args) {
		int[] ar = {4,2,1,5,3};
//		System.out.println(Arrays.toString(quickSort(ar)));
		quickSort2(ar,0,ar.length-1);
		System.out.println(Arrays.toString(ar));
	}
 static int[] quickSort(int[] ar) {
	 qs(ar, 0, ar.length -1);
	 return ar;
 }
private static void qs(int[] ar, int low, int high) {
	if(low < high) {
		int pIndex = partition(ar, low, high);
		qs(ar, low, pIndex -1);
		qs(ar, pIndex +1, high);
	}
	
}
private static int partition(int[] ar, int low, int high) {
	int pivot = ar[low];
	int i =low;
	int j= high;
	
	while(i <j) {
		while(ar[i] <= pivot && i <= high -1) {
			i++;
		}
		while(ar[j] > pivot && j >= low +1) {
			j--;
		}
		// now swap
		if(i <j) {
			swap(ar,ar[i], ar[j]);
		}
	 }
	swap(ar,ar[low],ar[j]);
	
	return j;
}
private static void swap(int[] ar,int i, int j) {
	int temp = ar[i];
	ar[i] = ar[j];
	ar[j] = temp;
	
}

/*
 * ====================================================================================================================
 * Another way of quickSort using pivot as mid of the array
 */
 
  static void quickSort2(int[] nums, int low, int high) {
	  if(low >= high) {
		  return;
	  }
	  
	  int start = low;
	  int end = high;
	  
	  int mid = start + (end - start)/2;
	  
	  int pivot = nums[mid];
	  
	  while(start <=end) {
		  while(nums[start] <pivot) {
			  start++;
		  }
		  while(nums[end] >pivot) {
			  end--;
		  }
		  
		  if(start<=end) {
			  int temp = nums[start];
			  nums[start] = nums[end];
			  nums[end] = temp;
			  start++;
			  end--;
		  }
		  
	  }
	// now my pivot is at correct index , please sort two halves now
	  quickSort2(nums, low, end);
	  quickSort2(nums, start, high);
  }
  /*
   * =======================================================================================
   * Quick sort by using mid  as a pivot element
   */
  static int quickSortMid(int[] ar, int low, int high) { // 41,19,65,21,78,28,87,52,59
	  													// left =ar[0] =>41, right =ar[8]=> 59 , pivot -ar[4]=> 78
	  int pivot = ar[low + (high - low)/2];
	  int left = low;
	  int right = high;
	  
	  while(true) {
		  while(ar[right] > pivot) { // 59>78 no
			  right--;
		  }
		  while(ar[left] < pivot) { // 41<78 now left=ar[1]=>19, left=ar[3]=>21, left = ar[4]=>78 
			  left++;         // now left =ar[6]=87   
		  }
		  if(left>=right) { 
			  return right; // right=52, right=6
		  }
		  swapMid(left,right);// swap bet 59,78 // swap bet 87 and 52- 41,19,65,21,59,28,52,87,78
		  left++; // left = ar[5]=> 28 left=87.
		  right--; // right = ar[7]=>52 ,  right =52
	  }
  }
  private static void swapMid(int left, int right) {
	int temp = left;
	left = right;
	right = temp;
	
}
}
