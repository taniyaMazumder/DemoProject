package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestDistinctWindowVariableK_GFG {
	public static void main(String[] args) {
//		String s ="AABBBCBBAC";
//		String s ="aaab";
		String s ="GEEKSGEEKSFOR";
		System.out.println(smallestSubstrDistinctChars(s));
	}

	public static int smallestSubstrDistinctChars(String s) {
		int i=0,j=0;
        int minLen = s.length();
        Set<Character> set = new HashSet<>();
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
            	 minLen = Math.min(minLen, count);
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
             return minLen;
	}
}
