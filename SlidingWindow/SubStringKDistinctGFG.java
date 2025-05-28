// Given a string str of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k distinct characters.

package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubStringKDistinctGFG {

	public static void main(String[] args) {
		String s="aba";
		System.out.println(countSubstr(s,2));

	}

	static int countSubstr(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0,j=0;
        int count =0;
        
        while(j<str.length()){
            char c = str.charAt(j);
            
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
            if(map.size() <k) {
                j++;
            }
            else if(map.size() ==k){
                count++;
                j++;
            }
            else if(map.size() >k){
                while(map.size()>k){
                    char ch = str.charAt(i);
                    if(map.containsKey(ch)) {
                        map.put(ch,map.get(ch) -1);
                        if(map.get(ch) ==0) {
                            map.remove(ch);
                        }
                    }
                    
                    i++;
                }
                j++;
            }
            
        }
        return count;
    }
}
