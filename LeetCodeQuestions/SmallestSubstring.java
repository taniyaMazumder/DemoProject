// Given a string with window size 2, find the substring whose sum of ASCII value of the character of that substring is minimum.


package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class SmallestSubstring {

	public static void main(String[] args) {
		String s ="geeksforgeeks";
		int k = 5;
		System.out.println(smallestSubstring2(s,k));

	}
	// approach - print all the substring first and then find the substring whose sum of ASCII value of the character of that substring is minimum.
	// time complexity is O(n)
	public static String smallestSubstring(String str, int k) {
	String ans ="";
    List<String> list = new ArrayList<>();
    
    for(int i=0; i<str.length();i++) {
    	String p= str.substring(i,Math.min(i+k, str.length()));
        if(p.length() == k) {
        	list.add(p);
        }
    }
    int sum =0;
    
    int min = Integer.MAX_VALUE;
    // now find ascii 
    
    for(int j =0; j<list.size();j++) {
    	sum=0;
        String t = list.get(j);
            for(int l =0; l<t.length();l++) {
                 char c = t.charAt(l);
                 sum += (int) c;
            }
          
            if(sum < min) {
                min = sum;
                ans = list.get(j);
            }
    }
    return ans;

}
/*
 * 	-----------------------------------------------------------------------------------------------------------------------
 * Optimization using sliding window Time complexity is O(1) & space complexity - O(1)
 */
	public static String smallestSubstring2(String str, int k) {
		
		
		int min = Integer.MAX_VALUE;
		String ans ="";
		int i= 0;
		int j=0;
		
		
		while(j < str.length()) {
			int sum =0;
			int l=0;
			if((j - i +1) < k) {
				j++;
			}
			else if((j -i +1) == k) {
				for(l=i;l<=j;l++) {
					char c = str.charAt(l);
					sum += (int) c;
	                
	           }
				if(sum < min) {
                	min = sum;
                	ans =  str.substring(i, j+1);
                }
				char temp =str.charAt(i);
				sum = sum - (int) temp;
				i++;
				j++;
			}
			
		}
		return ans;
	}
	
}
