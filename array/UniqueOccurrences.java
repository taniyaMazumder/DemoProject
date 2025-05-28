package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueOccurrences {

	public static void main(String[] args) {
		int[] arr = {1,2,2,1,1,3};
		System.out.println(uniqueOccurrences(arr));

	}
	//Using hashmap
 /*	public static void uniqueOccurrences(int[] arr) {
		Arrays.sort(arr); //1 1 1 2 2 3
		HashMap<Integer,Integer> map = new HashMap<>();
		int count =0;
		for (int i = 0; i < arr.length; i++) {
			
			if(i < arr.length -1 && arr[i] == arr[i+1]) {
				map.put(arr[i], i+1); // 1 1 , 1 2, 1 3  
			}
			else {
				HashMap<Integer,Integer> map2 = new HashMap<>();
				map2.put(arr[i+1], count); // 2 0  
				count++;
			}
			
		}
		    
    }
     */
	
	// with out set and map
	public static boolean uniqueOccurrences(int[] arr) {
	//	Arrays.sort(arr); //1 1 1 2 2 3
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
	//		if(i < arr.length -1 && arr[i] == arr[i+1]) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		
		HashSet<Integer> hashSet = new HashSet<>();
		boolean flag = true;
		for ( Map.Entry<Integer, Integer> s : map.entrySet()) {
			if(!hashSet.add(s.getValue())) {
				flag= false;
			}
		}
		return flag;
	}
}
