package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

	public static void main(String[] args) {
		int[] ar = {4,3,2,7,8,2,3,1};
		List<Integer> result = new ArrayList<>();
		result = findDuplicatesRetList(ar);
		System.out.println(result);
		
	}

	static int findDuplicates(int[] ar) {
		int i=0;
		while(i< ar.length) {
			
			if(ar[i] != i+1) {
				int correct = ar[i] -1;
				if(ar[i] != ar[correct]) {
					// swap
					swap(ar,i ,correct) ;
					
				}else {
					return ar[i];
				}
		   } else {
			   i++;
		   }
		}
		return -1;
	}
	// Finf duplicates and return in a list
	
	static List<Integer> findDuplicatesRetList(int[] ar) {
		int i=0;
		while(i< ar.length) {
			
			int correct = ar[i] -1;
				if(ar[i] != ar[correct]) {
					// swap
					swap(ar,i ,correct) ;
					
				}
		    else {
			   i++;
		   }
		}
		// Now find duplicates number
			List<Integer> list = new ArrayList<>();
			for (int index = 0; index < ar.length; index++) {
				if(ar[index] != index+1) {
					list.add(ar[index]);
				}
			}
			return list;
}
	static void swap(int[] ar, int first, int second) {
		
		int temp = ar[first];
		ar[first] = ar[second];
		ar[second] = temp;
	}
	// set mismatch
	static int[] findErrorNums(int[] ar) {
		int i=0;
		while(i< ar.length) {
				int correct = ar[i] -1;
				if(ar[i] != ar[correct]) {
					// swap
					swap(ar,i ,correct) ;
				
		   } else {
			   i++;
		   }
		
	// Now find duplicates number and missing number,  index =0 is duplicate no and index=1 -> is missing no 
				for (int index = 0; index < ar.length; index++) {
					if(ar[index] != index+1) {
						return new int[] {ar[index] , index +1};
					}
				}
		}
				return new int[] {-1,-1};
	}
}
