package BinarySearch;

import java.util.Arrays;

public class FindPositionTarget {

	public static void main(String[] args) {
		int[] ar = {5,8,13,22,59,59,59,78,91};
		int target =59;
		System.out.println(Arrays.toString(findPosition(ar, target)));
	}
	public static int[] findPosition(int[] ar, int target) {
		int[] answer = {-1,-1};
		
		answer[0] = search(ar, target,true);
		if(answer[0] != -1) {
			answer[1] = search(ar,target,false);
		}
		
		return answer;
	}
	public static int search(int[] ar, int target,boolean firstIndex) {
		int start =0;
		int end = ar.length -1;
		int ans =-1;
		while(start <=end) {
			int mid = start + (end-start)/2;
			
			if(target < ar[mid]) {
				end= mid -1;
			}
			else if(target == ar[mid]) {
				ans = mid;
				if(firstIndex) {
					end= mid -1;
				}
				else {
					start = mid+1;
				}
			}
			else {
				start = mid +1;
			}
		}
		return ans;
	}
}
