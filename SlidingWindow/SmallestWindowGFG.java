// Smallest window in a string containing all the characters of another string
// https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1?page=1&category=sliding-window&sortBy=submissions

package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowGFG {

	public static void main(String[] args) {
		String s1= "zoomlazapzo";
		String s2= "oza";
		System.out.println(smallestWindow(s1,s2));

	}

	public static String smallestWindow(String s1, String s2) {
		if(s1.length()<s2.length()){
            return "";
        }
        Map<Character,Integer> map = new HashMap<>();
        int k = s2.length();
        
         for(int l=0;l<k;l++) {
        	 char c = s2.charAt(l);
        	 if(map.containsKey(c)) {
        		 map.put(c, map.get(c)+1);
        	 } else {
        		 map.put(c, 1);
        	 }
         }
         int count = map.size();
         
         int i=0,j=0;
         
         int min = Integer.MAX_VALUE;
         int start= -1,end=-1;
         while(j<s1.length()) {
        	 char c2 = s1.charAt(j);
        	 if(map.containsKey(c2)) {
        		 map.put(c2, map.get(c2) -1);
        		 if(map.get(c2) ==0) {
        			 count--;
        		 }
        	 }
        	 if(count !=0) {
        		 j++;
        	 }
        	 else if(count ==0) {
        		 while(count ==0) {
        			 char c3 = s1.charAt(i);
        			 if(map.containsKey(c3)) {
        				 map.put(c3, map.get(c3) +1);
        				 if(map.get(c3) >0) {
        					 if(min > j-i+1) {
        						 min = j-i+1;
        						 start =i;
        						 end =j;
        					 }
        					 count++;
        				 }
        			 
        			 }
        			 i++;
        		 }
        		 j++;
        	 }
         }
        	 StringBuilder sb = new StringBuilder();
        	 if(start ==-1) {
        		 return "";
        	 }
        	 for(int d= start;d<=end;d++) {
        		 sb.append(s1.charAt(d));
        	 }
         
		return sb.toString();
         
    }
}
