 package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class FindOccurrencesHashMap {

	public static void main(String[] args) {
		int[] arr = {12, 9, 12, 9, 10, 9, 10, 11};
		   //  checkOccurrence(arr);
		  System.out.println(Arrays.toString(maxOccurrenceKey(arr)));
	}

	// how to find out occurrence of each element
			public static void checkOccurrence(int[] arr) {
				
				HashMap<Integer,Integer> map = new HashMap<>();
				for(int a : arr) {
					if(map.containsKey(a)) {
						map.put(a, map.get(a)+1);
					}else {
						map.put(a, 1);
					}
				}
				System.out.println("Arrays are: "+Arrays.toString(arr));
				System.out.println("occurences: "+map);
				
			}
			// most frequent value means find the max values of occurrence in HashMap then return it in an array 
			// it's returning the max occurrences values in the hashmap
			
			public static int[] maxOccurrence(int[] ar) {
				int[] result = new int[1];
				int max = Integer.MIN_VALUE;
				HashMap<Integer,Integer> map = new HashMap<>();
				
				for(int a : ar) {
					if(map.containsKey(a)) {
						map.put(a, map.get(a)+1);
						if(map.get(a) > max) {
							max = map.get(a);
							result[0] = max; 
						}
					}else {
						map.put(a, 1);
					}
				}
				return result;
			}
			// Now we need to return the key which is having max occurrences values
				public static int[] maxOccurrenceKey(int[] ar) {
						int[] result = new int[1];
						int max = Integer.MIN_VALUE;
						HashMap<Integer,Integer> map = new HashMap<>();
						
						for(int a : ar) {
							if(map.containsKey(a)) {
								map.put(a, map.get(a)+1);
								if(map.get(a) > max) {
									max = map.get(a);
									for(Entry<Integer, Integer> entry: map.entrySet()) {
										// if give value is equal to value from entry
									      // print the corresponding key
									      if(entry.getValue() == max) {
									    	  result[0] = entry.getKey();
									    	  break;
									      }
									  }
							}
						}else {
							map.put(a, 1);
						}
						
					}
						return result;
				}
}
