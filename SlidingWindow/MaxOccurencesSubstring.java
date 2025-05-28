package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxOccurencesSubstring {

	public static void main(String[] args) {
		String s ="aababcaab";
		int maxLetters = 2, minSize = 3, maxSize = 4 ;
		System.out.println(maxFreq(s,maxLetters,minSize,maxSize));
	}

	public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int i=0,j=0;
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> subString = new HashMap<>();
        int ans =0;
        String t="";
        StringBuffer sb = new StringBuffer(t);
        int start =-1, end =-1;
        while(j<s.length()) {
        	char c = s.charAt(j);
        	if(map.containsKey(c)) {
        		map.put(c, map.get(c) +1);
        	}
        	else {
        		map.put(c, 1);
        	}
        	int count = map.size(); // this count is uniq char
        	
        	if( count< maxLetters && j-i+1 <minSize) {
        		j++;
        	}
        	
        	else if(count== maxLetters && j-i+1 >= minSize && j-i+1 <maxSize) {
        		start =i;
        		end = j;
        		for(int m =start; m<=end; m++) {
        			sb.append(s.charAt(m));
        			System.out.println("sb print" +sb);
        		}
        		for(int g =start; g<=end; g++) {
	        		char ch = sb.charAt(g);
	            	if(subString.containsKey(ch)) {
	            		subString.put(ch, subString.get(ch) +1);
	            	}
	            	else {
	            		subString.put(ch, 1);
	            	}
        		}
        		ans++;
        		j++;
        	}
        	else if(j-i+1 >= maxSize) {
//        		while(j-i+1 >= maxSize) {
//        			char c2 = s.charAt(i);
//        			if(map.containsKey(c2)) {
//                		map.put(c2, map.get(c2) -1);
//                		if(map.get(c2) ==0) {
//                			map.remove(c2);
//                			count--;
//                		}
//                		
//                	 }
//        			i++;
//        		}
//        		j++;
//        		
//        	}
        		ans = findAnagrams(s,sb.toString());
            }
        }
		return ans;
        
    }
	public static int findAnagrams(String s, String p) {
       int ans =0;
        
        int k = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<k;i++){
            char ch = p.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch, 1);
            }
        }
        
        int count = map.size();
        int i = 0, j = 0;
        
        while(j < s.length()){
            // Calculation:
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0){
                    count--;
                }
            }
           if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                if(count == 0){
                    ans++;
                }
                char ch1 = s.charAt(i);
                if(map.containsKey(ch1)){
                    map.put(ch1, map.get(ch1)+1);
                    if(map.get(ch1) == 1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        
        return ans;
    }
	/* 
	public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		int i=0,j=0;
        Map<Character,Integer> map = new HashMap<>();
        int ans =0;
        while(j<s.length()) {
        	char c = s.charAt(j);
        	if(map.containsKey(c)) {
        		map.put(c, map.get(c) +1);
        	}
        	else {
        		map.put(c, 1);
        	}
        	int count = map.size(); // this count is unique char
        	
        	if( map.size()< maxLetters && j-i+1 <minSize) {
        		j++;
        	}
        	
        	else if(map.size()== maxLetters && j-i+1 >= minSize && j-i+1 <maxSize) {
        		ans++;
        		j++;
        	}
        	else if(j-i+1 >= maxSize && map.size() > maxLetters) {
        		while(j-i+1 >= maxSize && map.size() > maxLetters) {
        			char c2 = s.charAt(i);
        			if(map.containsKey(c2)) {
                		map.put(c2, map.get(c2) -1);
                		if(map.get(c2) ==0) {
                			map.remove(c2);
                			count--;
                		}
                		
                	 }
        			i++;
        		}
        		j++;
        		
        	}
        }
		return ans;
	} */
	
}
