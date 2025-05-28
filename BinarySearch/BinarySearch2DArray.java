package BinarySearch;

import java.util.Arrays;

public class BinarySearch2DArray {

	public static void main(String[] args) {
		int[][] ar = {
				{10,20,30,40},
				{15,25,35,45},
				{28,29,37,49},
				{33,34,38,50}
		};
       int target = 37;
       System.out.println(Arrays.toString(search(ar,target)));
	}
	// TC- O(n) + O(log(row X column)), SC- O(1)

	static int[] search(int[][] matrix, int target) {
		int row=0;
		int col = matrix.length -1;
		
		while(row < matrix.length && col >= 0) {
			if(matrix[row][col] == target) {
				return new int[] {row,col};
			}
			else if(matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return new int[] {-1,-1};
	}
	
	// TC- O(log(row X column)), SC- O(1) 
	// Convert 1D array into 2D array
	
	static boolean binarysearch2D(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length ;
		int start=0; 
		int end = n*m -1;
		
		while(start <= end) {
			int mid = (start + end) /2;
			int row = mid / m;
			int col = mid % m;
			
			if(matrix[row][col] == target) {
				return true;
			}
			else if(matrix[row][col] < target) {
				start = mid +1;
			}
			else {
				end = mid -1;
			}
		}
		return false;
		
	}
}
