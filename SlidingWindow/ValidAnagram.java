package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
//		String s = "a";
//		String t = "ab";
//		String s = "aacc";
//		String t = "ccac";
		System.out.println(isAnagram(s,t));

	}
	
	// Brute force solution in O(n^2)
	public static boolean bruteForceSol(String s, String t) {
		boolean flag = true;
		for(int i=0; i< s.length();i++) {
			for(int j=0; j< t.length();j++) {
				if(s.charAt(i) == t.charAt(j)) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}
	// reduce time complexity in O(n)
	public static boolean isAnagram(String s, String t) {
		Map<Character,Integer> map = new HashMap<>();
       
        for(int k = 0; k< s.length(); k++){
            char ch = s.charAt(k);
	            if(map.containsKey(ch)){
	                map.put(ch, map.get(ch) +1);
	            } else {
	                map.put(ch,1);
	            }
        	}
        int j =0;
        int count = map.size();
        if(s.length() != t.length()) {
            return false;
        }
        else {
            while(j< t.length()) {
        	char ch1 = t.charAt(j);
        	if(map.containsKey(ch1)){
                map.put(ch1, map.get(ch1) -1);
                if(map.get(ch1) == 0) {
                	map.remove(ch1);
                	count--;
               }
                
        	}
        	else if(count !=0) {
                return false;
             }
        	else if(!map.containsKey(ch1)) {
        		return false;
        	}
        	j++;
          }
        }
       return true;
		}
	}


