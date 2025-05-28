package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringDistinctCharVariableSLW {

	public static void main(String[] args) {
		String s ="geeksforgeeks";
		System.out.println(longestSubstrDistinctChars(s));
	}

	public static int longestSubstrDistinctChars(String s) {
		int i=0,j=0;
        int max = Integer.MIN_VALUE;
        
        Map<Character, Integer> map = new HashMap<>();
        while(j<s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) +1);
            } else {
                map.put(ch,1);
            }
            int count = map.size();
             if(count == j-i+1){
                 max = Math.max(max, j-i+1);
                 j++;
             }
             else if(count <j-i+1) {
                 while(count <j-i+1) {
                     char ch2 = s.charAt(i);
                     map.put(ch2, map.get(ch2) -1);
                      if(map.get(ch2) ==0) {
                          map.remove(ch2);
                      }
                      i++;
                 }
                 j++;
             }
        }
             return max;
	}
}
