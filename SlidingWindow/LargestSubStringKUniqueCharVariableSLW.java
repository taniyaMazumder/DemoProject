package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LargestSubStringKUniqueCharVariableSLW {

	public static void main(String[] args) {
	//	String s="ababbc";
		String s="aabacbebebe";
		System.out.println(findMaxLengthSubString(s,3));

	}

	static int findMaxLengthSubString(String s, int k) {
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
		//	int count = map.size();
			if(map.size() <k ) {
				j++;
			}
			
//			// if k  char count hits k
			else if(map.size() == k) {
				max = Math.max(max, j - i +1);
				j++;
			}
			else if(map.size() >k ) {
				while(map.size() >k) {
					char ch2  = s.charAt(i);
						if(map.containsKey(ch2)) {
							map.put(ch, map.get(ch2) -1);
							if(map.get(ch2) ==0) {
								map.remove(ch2);
						    }
						}
						i++;
					}
				j++;
			}
		}
		return max;
	}
}
