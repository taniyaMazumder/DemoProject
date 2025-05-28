package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> finalList = new ArrayList<>();
		finalList.addAll(combinationSum(candidates, target));
		System.out.println(finalList);
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		List<List<Integer>> outer = new ArrayList<>();
		helper(candidates, target,0,outer,new ArrayList<>());
        return outer;
    }
	public static void helper(int[] candidates, int target, int index, List<List<Integer>> outer, List<Integer> internal) {
		if(index == candidates.length ) {
			if(target ==0) {
				outer.add(new ArrayList<>(internal));
			}
			return;
		}
	
		if(candidates[index] <= target) {
			internal.add(candidates[index]);
			 helper(candidates, target - candidates[index] , index, outer, internal);
			 internal.remove(internal.size() -1);
		}
		helper(candidates, target , index +1, outer, internal);
	}
}
