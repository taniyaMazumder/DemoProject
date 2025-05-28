// here 1-n array
package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class NumbersDisappeared {

	public static void main(String[] args) {
		int[] ar = {4,3,2,7,8,2,3,1};
		List<Integer> result = new ArrayList<>();
		result = missingNumbers(ar);
		System.out.println(result);
	}

	static List<Integer> missingNumbers(int[] ar) {
		int i=0;
		while(i<ar.length) {
			int correct = ar[i] -1;
			if(ar[i] != ar[correct]) {
				// swap
				swap(ar,i ,correct) ;
				
			}else {
				i++;
			}
		}
		
		// Now find missing number - incorrect index
		List<Integer> list = new ArrayList<>();
		for (int index = 0; index < ar.length; index++) {
			if(ar[index] != index+1) {
				list.add(index +1);
			}
		}
		return list;
}
	
	static void swap(int[] ar, int first, int second) {
		
		int temp = ar[first];
		ar[first] = ar[second];
		ar[second] = temp;
	}
	
	
}
