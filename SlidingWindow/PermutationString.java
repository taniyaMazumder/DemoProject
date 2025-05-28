// Given two strings, find whether 1 string's permutation substring is present on another string or not
// if present then return true  otherwise false.
// it is similar to anagram
package SlidingWindow;

import java.util.HashMap;

public class PermutationString {

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidcaooo";
		System.out.println(findPermutations(s1,s2));

	}

	public static boolean findPermutations(String s1, String s2) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		int k = s1.length();
		
        for(int i=0;i<k;i++){
            char ch = s1.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch, 1);
            }
        }
        
        int count = map.size();
		int i=0, j=0;
		while(j< s2.length()) {
			// calculation
			char ch1 = s2.charAt(j);
			if(map.containsKey(ch1)){
                map.put(ch1, map.get(ch1)-1);
                if(map.get(ch1) ==0) {
                	count --;
                }
            }
			if(j-i+1 <k) {
				j++;
			}
			else if(j-i+1 ==k) {
				// calculation
				if(count==0) {
					return true;
				}
				char ch2 = s2.charAt(i);
				if(map.containsKey(ch2)){
	                map.put(ch2, map.get(ch2)+1);
	                if(map.get(ch2) ==1) {
	                	count ++;
	                }
	            }
				i++;
				j++;
			}
			
		}
		return false;
	}
}
