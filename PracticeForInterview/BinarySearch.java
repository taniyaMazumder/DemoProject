package PracticeForInterview;

public class BinarySearch {

	public static void main(String[] args) {
	//	int[] ar = {5,8,13,22,35,59,78,91};
//		int[] ar = {91,78,67,59,48,22,13,5};
//		int target =48;
//		System.out.println(binarySearchOrderAg(ar, target));
		int[] ar = {5,8,13,22,59,59,59,78,91,111,121,230,350};
		int target =111;
		System.out.println(ans(ar, target));

	}
	/*
	 * int search
	 */

	private static int binarySearch(int[] ar, int target) {
		int start =0;
		int end = ar.length -1;
		
		while(start <=end) {
			int mid = start + (end - start)/2;
			
			if(target == ar[mid]) {
				return mid;
			}
			else if(target <ar[mid]) {
				end = mid-1;
			}
			else if(target >ar[mid]) {
				start = mid +1;
			}
		}
		return -1;
	}

	/*
	 * order agonstics
	 */
	
	private static int binarySearchOrderAg(int[] ar, int target) {
		int start =0;
		int end = ar.length -1;
		
		boolean isAsc;
		if(ar[start] < ar[end]) {
			isAsc = true;
		} else {
			isAsc = false;
		}
		while(start <=end) {
			int mid = start + (end - start)/2;
			
			if(target == ar[mid]) {
				return mid;
			}
			if(isAsc) {
				if(target <ar[mid]) {
					end = mid-1;
				}
				else {
					start = mid +1;
				}
			}
			else {
				if(target >ar[mid]) {
					end = mid-1;
				}
				else {
					start = mid +1;
				}
			}
			
		}
		return -1;
	}
	/*
	 * Find first and last position
	 */
	static int[] findPos(int[] ar, int target) {
		int[] ans = new int[] {-1,-1};
	//	boolean isFirstIndex;
		int start = binarySearchOcc(ar, target, true);
		int end=  binarySearchOcc(ar, target, false);
		
		ans[0] = start;
		ans[1] = end;
		
		
		return ans;
	}
	private static int binarySearchOcc(int[] ar, int target, boolean isFirstIndex) {
		int start =0;
		int end = ar.length -1;
		int res =-1;
		while(start <=end) {
			int mid = start + (end - start)/2;
			
			if(target == ar[mid]) {
				res = mid;
				if(isFirstIndex) {
					end = mid-1;
				}
				else {
					start = mid+1;
				}
				
			}
			else if(target <ar[mid]) {
				end = mid-1;
			}
			else if(target >ar[mid]) {
				start = mid +1;
			}
		}
		return res;
	}
	
	/*
	 * infinite array
	 */
	static int ans(int[] arr, int target) {
        // first find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while (target > arr[end]) {
            int temp = end + 1; // this is my new start
            // double the box value
            // end = previous end + sizeofbox*2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);

    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
    
   
}
