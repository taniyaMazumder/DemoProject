package Recursion;

public class RotatedArrayBinarySearchRec {

	public static void main(String[] args) {
		int[] arr= {5,6,7,8,9,1,2,3};
		int target = 2;
		System.out.println(rotatedBS(arr,target, 0, arr.length -1));
	}

	static int rotatedBS(int[] ar, int target, int start, int end) {
		if(start > end) {
			return -1;
		}
		int mid = start +(end - start)/2;
		
		// 3 cases
		if(target == ar[mid] ) {
			return mid;
		}
		
		if(ar[start] <= ar[mid]) {
			if(target >= ar[start] && target <= ar[mid]) {
				return rotatedBS(ar,target, start,mid -1);
			}
			else {
				return rotatedBS(ar,target, mid +1,end);
			}
		}
		if(target >= ar[mid] && target <= ar[end]) {
			return rotatedBS(ar,target, mid +1,end);
		}
		return rotatedBS(ar,target, start,mid -1);
	}
	
	// rotated BS solution 2
		static int rotatedBS2(int[] ar, int target, int start, int end) {
			if(start > end) {
				return -1;
			}
			int mid = start +(end- start)/2;
			
			if(target == ar[mid] ) {
				return mid;
			}
			
			if(ar[start] <ar[mid]) {
				if(ar[start] <= target && target <= ar[mid]) {
					return rotatedBS2(ar, target, start, mid-1);
				}else {
					return rotatedBS2(ar, target, mid+1, end);
				}
			} else {
				if(ar[mid] <= target && target <= ar[end]) {
					return rotatedBS2(ar, target, mid+1, end);
				} else {
					return rotatedBS2(ar, target, start, mid-1);
				}
			}
		}
}
