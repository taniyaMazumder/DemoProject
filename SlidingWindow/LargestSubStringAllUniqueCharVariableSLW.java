// Given a string .
// Find the length of the substring which is having max length of substring whose having all unique char or no repeating char
// Hence unique char will be equal to the window size

package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestSubStringAllUniqueCharVariableSLW {

	public static void main(String[] args) {
		String s="GEEKSGEEKSFOR";
		System.out.println(findMaxLengthSubStringAllUniq(s));

	}

	static int findMaxLengthSubStringAllUniq(String s) {
		int i=0,j=0;
		int max = Integer.MIN_VALUE;
		Map<Character,Integer> map = new HashMap<>();
		
		while(j < s.length()) {
			
			// calculation
			// enter the char into the map and get count 
			char ch = s.charAt(j);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) +1);
			}
			else {
				map.put(ch, 1);
			}
//			if(map.size() >  j -i +1) { // this condition will never hit cz map stores all the char which is available in windows
										// so map size will never be increased more than window size
//				j++;
//			}
			// if unique char count hits k
			if(map.size() == j -i +1) {
				max = Math.max(max, j - i +1);
				j++;
			}
			// if map size increased more than unique char 
			else if(map.size() < j -i +1) {
				while(map.size() < j -i +1 ) {
					char ch1 = s.charAt(i);
					int count = map.get(ch1);
					map.put(ch1, count -1);
					if(map.get(ch1) ==0) {
						map.remove(ch1);
					}
					i++;
				}
				j++;
			}
		}
		return max;
	}
	

}
