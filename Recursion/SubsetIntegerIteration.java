package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetIntegerIteration {

	public static void main(String[] args) {
		int[] ar = {1,2,2};
		
		List<List<Integer>> list = subsetDuplicateRec(ar);
		System.out.println(list);
	}
// solved through iteration = TC- O(N* 2^N) here 2^N is no of subsets and N is how many elements in the array
	// SC- O(2^N *N) here  2^N is no of subsets and N is space taken by each subsets
	static List<List<Integer>> subset(int[] arr) {
		List<List<Integer>> outer = new ArrayList<>();
		
		outer.add(new ArrayList<>());
		
		for(int num: arr) {
			int size = outer.size();
			for(int i=0; i < size; i++) {
				ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
				internal.add(num);
				
				outer.add(internal);
			}
			
		}
		return outer;
	}
	
	//removing duplicate subset
	static List<List<Integer>> subsetDuplicate(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> outer = new ArrayList<>();
		
		outer.add(new ArrayList<>());
		
		int start=0;
		int end =0;
		// if current and prev elements are same then start = end +1
		for (int i = 0; i < arr.length; i++) {
			start =0;
			if(i>0 && arr[i] == arr[i-1]) {
				start = end +1;
			}
			end = outer.size();
			int size = outer.size();
			for(int j=start; j < size; j++) {
				ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
				internal.add(arr[i]);
				outer.add(internal);
			}
		}
		return outer;
	}
	// Remove duplicate subset using recursion
	static List<List<Integer>> subsetDuplicateRec(int[] arr) {
		return helper(arr, 0, 0 , 0, 0);
	}
	
	static List<List<Integer>> helper(int[] arr, int start, int end, int i, int j) {
		Arrays.sort(arr);
		List<List<Integer>> outer = new ArrayList<>();
		if(i == arr.length) {
			if(j < outer.size()) {
				ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
				internal.add(arr[i]);
				outer.add(internal);
			}
			return outer;
		}
		
		// if current and prev elements are same then start = end +1
		
			if(i>0 && arr[i] == arr[i-1]) {
				start = end +1;
			}
			end = outer.size();
			//int size = outer.size();
			
			return helper(arr,start, end, i+1, j+1);
		}
	
}
