package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DivisibleSubsetRec {

	public static void main(String[] args) {
		int[] ar = {4,6,10};
//		findSubset(ar);
		System.out.println(findSubsetRetIndx(ar));

	}

	// Print if there is any subsets exists that the sum of the subset's elements which is divisible by the size of the array
	static void findSubset(int[] ar) {
		List<Integer> list = new ArrayList<>();
		helper(ar,0,list);
	}

	private static void helper(int[] ar, int index, List<Integer> list) {
		int sum =0;
		for(int i:list) {
			sum += i;
		}
		// Base condition
		if(index == ar.length) {
			if(!list.isEmpty() && sum % ar.length == 0) {
				System.out.println(list);
			}
			return;
		}
		
		// exclude from the list
		helper(ar, index+1, list);
        // include into the list
		list.add(ar[index]);
		helper(ar, index+1, list);
		
		list.remove(list.size() -1);
	}
	
	 
	// Return list of indices of the subsets exists that the sum of the subset's elements which is divisible by the size of the array
		static List<Integer> findSubsetRetIndx(int[] ar) {
			List<Integer> list = new ArrayList<>();
			return helper2(ar,0,list);
			
		}

		private static List<Integer> helper2(int[] ar, int index, List<Integer> list) {
			List<Integer> indices = new ArrayList<>();
			int sum =0;
			for(int i:list) {
				sum += i;
			}
			// Base condition
			if(index == ar.length) {
				if(!list.isEmpty() && sum % ar.length == 0) {
					
//					System.out.println(list);
					for(int j=0; j<list.size();j++) {
						indices.add(list.get(j));
					}
					
				}
				return indices;
			}
			
			// exclude from the list
			helper2(ar, index+1, list);
	        // include into the list
			list.add(ar[index]);
			helper2(ar, index+1, list);
			
			list.remove(list.size() -1);
			return indices;
			
		}
}
