// Given two strings and output- index of first char when anagrams will found in string s

package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinAString {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s,p));
	}

	public static List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int k = 0; k< p.length(); k++){
            char ch = p.charAt(k);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) +1);
            } else {
                map.put(ch,1);
            }
        }
        int count = map.size();
        int i=0,j=0;
        int k = p.length();
        while(j < s.length()) {
            char ch1 = s.charAt(j);
            if(map.containsKey(ch1)){
                map.put(ch1, map.get(ch1) -1);
                if(map.get(ch1) ==0){
                    count--;
                }
            }
            if(j - i +1 <k){
                j++;
            }
            else if(j - i +1 == k) {
                if(count ==0) {
                    ans.add(i);
                 }
                char ch2 = s.charAt(i);
                if(map.containsKey(ch2)){
                    map.put(ch2, map.get(ch2) +1);
                    if(map.get(ch2) ==1){
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
