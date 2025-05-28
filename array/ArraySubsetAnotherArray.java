package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set; 

public class ArraySubsetAnotherArray {

	public static void main(String[] args) {
//		int[] ar1 = {11, 7, 1, 13, 21, 3, 7, 3};
//		int[] ar2= {11, 3, 7, 1, 7};
	//	System.out.println(findsubset(ar1,ar2));
	//	System.out.println(findsubsetUsingBinarySearch(ar1,ar2));
		long[] ar1 = {11, 7, 1, 13, 21, 3, 7, 3};
		long[] ar2= {11, 3, 7, 1, 20};
		System.out.println(isSubset(ar1,ar2,ar1.length,ar2.length));
	}

	// Solution-1: Using two for loops- time complexity -O(m * n), space complexity-1
	static boolean findsubset(int[] arr1, int[] arr2) {
		int i=0;
		int j=0;
		
		for (i = 0; i < arr2.length; i++) {
			for (j = 0; j < arr1.length; j++) {
				if(arr2[i] == arr1[j]) {
					break;
				}
			}
				if(j == arr1.length) {
					return false;
				}
		}
		return true;
	}
	// Solution -2- using sorting and binary search apart from using linear search
	// TC- for sorting O(mlogm), BS- O(nLogm) where n- length of arr2, m- length of arr1
	// Overall TC- O(mLog(m) + nlog(m))
	// SC-O(n)
	
	static boolean findsubsetUsingBinarySearch(int[] arr1, int[] arr2) {
		// step-1 - sort array1 in asc order
		Arrays.sort(arr1);
		// step -2 Call the binary search method
		for (int i = 0; i < arr2.length; i++) {
			if(binarysearch(arr1, 0, arr1.length,arr2[i]) ==-1) {
				return false;
			}
		}
		return true;
	}

	private static int binarysearch(int[] arr1, int start, int end, int target) {
		if(start > end) {
			return 0;
		}
		while(start <=end) {
			int mid = start + (end-start)/2;
			if(target < arr1[mid]) {
				end = mid-1;
			}
			else if(target > arr1[mid]) {
				start = mid+1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	// returning long data types
	public static String isSubset( long a1[], long a2[], long n, long m) {
		// step-1 - sort array1 in asc order
				Arrays.sort(a1);
				// step -2 Call the binary search method
				for (int i = 0; i < m; i++) {
					if(binarysearchLong(a1, 0, n,a2[i]) ==-1) {
						return "No";
					}
				}
				return "Yes";
        
    }
	private static long binarysearchLong(long[] arr1, long start, long end, long target) {
		if(start > end) {
			return 0;
		}
		while(start <=end) {
			long mid = start + (end-start)/2;
			if(target < arr1[(int) mid]) {
				end = mid-1;
			}
			else if(target > arr1[(int) mid]) {
				start = mid+1;
			}
			else {
				return (int) mid;
			}
		}
		return -1;
	}
	public String isSubset2( long a1[], long a2[], long n, long m) {
		// step-1 - sort array1 in asc order
		Arrays.sort(a1);
		// step -2 Call the binary search method
		for (int i = 0; i < m; i++) {
			if(binarysearchLong(a1, 0, n-1,a2[i]) ==-1) {
				return "No";
			}
		}
		return "Yes";

	}
		
	
private static long binarysearchLong2(long[] arr1, long start, long end, long target) {
if(start > end) {
return 0;
}
while(start <=end) {
long mid = start + (end-start)/2;
if(target < arr1[(int) mid]) {
	end = mid-1;
}
else if(target > arr1[(int) mid]) {
	start = mid+1;
}
else {
	return  mid;
}
}
return -1;
}

public String isSubset3( long a1[], long a2[], long n, long m) {
    Set<Long> s = new HashSet<>();
   for (int i = 0; i < m; i++) {
       s.add(a1[i]);
   }
   int p = s.size();
   for (int i = 0; i < n; i++) {
       s.add(a2[i]);
   }

   if (s.size() == p) {
	   return "Yes";
   }
   else {
	   return "No";
   }
}
}
