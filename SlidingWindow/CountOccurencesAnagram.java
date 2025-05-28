//Find All Anagrams in a String.
// Given 2 strings and find anagrams of 1 string and find how many of those anagrams present in another string

package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountOccurencesAnagram {

	public static void main(String[] args) {
		String s = "forxxorfxdofr";
		String p="for";
		System.out.println(countAnagrams(s,p));

	}
	public static int countAnagrams(String s, String p) {
        int ans = 0;
        
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
}
