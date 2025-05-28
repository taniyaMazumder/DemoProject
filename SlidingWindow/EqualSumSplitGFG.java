// Given an array , return true or false if the array can be split in two sub arrays without reordering the elements
package SlidingWindow;

public class EqualSumSplitGFG {

	public static void main(String[] args) {
	//	int[] ar= {4,3,2,1};
	//	int[] ar = {1, 2, 3, 4, 5, 5};
		int[] ar= {4, 1, 2, 3, 4};
		System.out.println(canSplit(ar));

	}

	public static boolean canSplit(int arr[]) {
        int totalSum =0;
        for(int i=0;i<arr.length;i++) {
        	totalSum += arr[i];
        }
        if(totalSum %2 != 0) {
        	return false;
        } else {
        	int leftSum = 0;
        	for(int i=0;i<arr.length;i++) {
        		leftSum += arr[i];
        		
        		if(leftSum == totalSum /2) {
        			return true;
        		}
            }
        	return false;
        }
	}
	
}
