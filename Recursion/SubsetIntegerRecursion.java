package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class SubsetIntegerRecursion {

	public static void main(String[] args) {
		int[] arr= {1,2,2};
	//	List<Integer> list = new ArrayList<>();
	//	subset(arr,0,list);
//		System.out.println(subsetRetList(arr));
		System.out.println(uniqueSubsets(arr));

	}

	private static void subset(int[] arr, int index, List<Integer> list) {
		if(index == arr.length) {
			System.out.println(list);
			return;
		}
		// Exclude the current element
		subset(arr,index +1, list);
		
		// Include the current element into the list
		list.add(arr[index]);
		subset(arr,index +1, list);
		
		// backtrack
		list.remove(list.size() -1);

	}
	// Return in List<List<Integer> . O/p will be- [ [], [3],[2],[2,3],[1],[1,3],[1,2],[1,2,3]]
	private static List<List<Integer>> subsetRetList(int[] arr) {
		List<List<Integer>> res = new ArrayList<>(); 
		if(arr.length == 0) {
			return res;
		}
		List<Integer> temp = new ArrayList<>();
		helper(arr,0, res,temp);
		return res;
	}
	
	private static void helper(int[] arr, int index, List<List<Integer>> outer, List<Integer> internal) {
		if(index == arr.length) {
			outer.add(new ArrayList<>(internal));
			return ;
		}
		internal.add(arr[index]);
		// Exclude the current element
		helper(arr,index +1, outer,internal);
		// Backtrack
		internal.remove(internal.size() -1);
		
		helper(arr,index +1, outer,internal);
		return ;
		
	}

	// remove duplicate subsets
	// To find unique subsets
	public static void findUniqueSubsets(int[] arr, int index, List<Integer> internal, Set<List<Integer>> outer) {
		// base condition
		if(index == arr.length) {
			outer.add(new ArrayList<>(internal));
			return;
		}
		// include the current element
		internal.add(arr[index]);
		findUniqueSubsets(arr, index +1, internal, outer);
		
		// exclude the current element
		// backtrack
		internal.remove(internal.size() -1);
		findUniqueSubsets(arr, index +1, internal, outer);
		 return;
	}
	
	public static List<List<Integer>> uniqueSubsets(int[] arr) {
		// sort the array first to get the duplicate elements to be adjacent
		Arrays.sort(arr);
		Set<List<Integer>> list = new HashSet<>();
		
		findUniqueSubsets(arr,0,new ArrayList<>(), list);
		return new ArrayList<>(list);
	}
	
}
