package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public static void main(String[] args) {
		int k =3, n =7;
		System.out.println(combinationSum3(k,n));

	}
 
	static List<List<Integer>> combinationSum3(int k , int n) {
		List<List<Integer>> ans = new ArrayList<>();
		helper(k,n,1, ans, new ArrayList<>());
		return ans;
	}
	static void helper(int k, int n,int index , List<List<Integer>> outer, List<Integer> internal ) {
		if(k ==0 && n ==0) {
			outer.add(new ArrayList<>(internal));
			return;
		}
		// if n or k become -ve
		if(k <0 || n<0) {
			return;
		}
		for (int i = index; i <= 9; i++) {
			internal.add(i);
			helper(k-1, n-i, i +1, outer, internal);
			internal.remove(internal.size() -1);
		}
	}
	
}
