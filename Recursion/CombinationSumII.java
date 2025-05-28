// Each elements of the array should take only once to get target
// Also duplicate combinations not allowed
package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
//		List<List<Integer>> finalList = new ArrayList<>();
//		finalList.addAll(combinationSum(candidates, target));
//		System.out.println(finalList);
		System.out.println(combinationSum2WithoutDuplicate(candidates, target));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		List<List<Integer>> outer = new ArrayList<>();
		helperWithDuplicate(candidates,target,0, outer, new ArrayList<>());
		return outer;
    }
	public static void helperWithDuplicate(int[] candidates, int target, int index, List<List<Integer>> outer, List<Integer> internal ) {
		if(index == candidates.length ) {
			if(target ==0) {
				outer.add(new ArrayList<>(internal));
			}
			return;
		}
		if(candidates[index] <= target) {
			
			internal.add(candidates[index]);
			helperWithDuplicate(candidates, target - candidates[index] , index +1, outer, internal);
			internal.remove(internal.size() -1);
			 
		}
		helperWithDuplicate(candidates, target , index +1, outer, internal);
	}

// without duplicate - TC- 2^n * k * log(x) where n is no of elements in the array and K is avg time taken by every combinations to store in List<List<>>
//  and x is size of set, so it's taking huge time & space by using set 
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
        Set<List<Integer>> outer = new HashSet<>();
        List<Integer> internal = new ArrayList<>();
        helper2(candidates, target,0, outer, internal);
        return new ArrayList<>(outer) ;
    }
    static void helper2(int[] candidates, int target, int index, Set<List<Integer>> outer,  List<Integer> internal) {
        if(index == candidates.length) {
            if(target ==0) {
                outer.add(new ArrayList<>(internal));
                
            }
            return ;
        }
            if(candidates[index] <= target) {
                internal.add(candidates[index]);
                helper2(candidates, target - candidates[index],index +1 ,outer,internal);
                internal.remove(internal.size()-1);
            }
             helper2(candidates, target ,index +1,outer,internal);
        }
 
 /*
  * -----------------------------------------------------------------------------------------------------------------------------------------------
  * The above solution can cause time limit exceeded cz many subsets can create for a long similar elements array like
  * [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
  * 
  * In this use case we ignore the duplicate
  */
    // Solution-2 - TC- 2^n * k where n is no of elements in the array and K is avg time taken by every combinations to store in List<List<>>
    // SC - K * x where k is avg length of array is K and x no of combinations made.
 static List<List<Integer>> combinationSum2WithoutDuplicate(int[] ar, int target) {
	 List<List<Integer>> ans = new ArrayList<>();
	 Arrays.sort(ar);
	 helper3(ar, target, 0, ans, new ArrayList<>());
	 return ans;
 }
 static void helper3(int[] ar, int target, int index, List<List<Integer>> outer, List<Integer> internal) {
	 // Base condition
	 
		 if(target ==0) {
			 outer.add(new ArrayList<>(internal));
			 return;
		 }
		 
		
	// Need to take a loop to get the multiple calls for below recursive calls
	   for(int i = index; i< ar.length; i++) {
		   if(i>index && ar[i] == ar[i-1]) {
			   continue;
		   }
		   if(ar[i] > target) {
			   break;
		   }
		   internal.add(ar[i]);
		   helper3(ar, target - ar[i], index +1, outer, internal);
		   internal.remove(internal.size() -1);
		   
	   }
	 }
   
 }

