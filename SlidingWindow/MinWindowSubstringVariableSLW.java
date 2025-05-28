// Given two strings. str a is long, str b is short
// Find minimum window of substring where 
package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinWindowSubstringVariableSLW {

	public static void main(String[] args) {
//		String s="TOTMTAPTAT";
//		String t="TTA";
		String s= "zoomlazapzo";
		String t= "oza";
	//	System.out.println(findMinSubstringLength(s,t));
		System.out.println(findMinSubstringLengthRetStr(s,t));
	}

	static int findMinSubstringLength(String s, String t) {
		Map<Character,Integer> map = new HashMap<>();
	//	List<Character> ans = new ArrayList<>();
		
		for(int i = 0; i< t.length(); i++) {
			char ch = t.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) +1);
			}
			else {
				map.put(ch, 1);
			}
		}
		int i=0, j=0;
		int count = map.size();
		int minLen = Integer.MAX_VALUE;
		while (j < s.length()) {
			// calculation
			char ch = s.charAt(j);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) -1);
				if(map.get(ch) == 0) {
					count --;
				}
			}
			if(count !=0) {
				j++;
			}
			else if(count ==0) {
				while(count ==0) {
					char ch1 = s.charAt(i);
					if(map.containsKey(ch1)) {
						map.put(ch, map.get(ch) +1);
					
					if(map.get(ch) >0) {
						
						if(j-i +1 < minLen) {
							minLen = j-i +1;
						}
						count++;
					  }
					}
					i++;
				}
				j++;
			}
		}
		return minLen;
			
		}
	
	// print substring min window
	static String findMinSubstringLengthRetStr(String s, String t) {
		
	        if(s.length()<t.length()){
	            return "";
	        }
	    
	        int res = Integer.MAX_VALUE;
			int i = 0;
			int j = 0;
			int count = 0;
			int jx=-1;
			int ix=-1;
			Map<Character, Integer> map = new HashMap<>();
			for (int x = 0; x < t.length(); x++) {
				char c = t.charAt(x);
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				}
	            else{
				map.put(c, 1);
	            }
			}
			count = map.size();
			while (j < s.length()) {
				char c = s.charAt(j);
				if (map.containsKey(c)) {
					map.put(c, map.get(c) - 1);
					if (map.get(c) == 0) {
						count--;
					}
				}
				if (count != 0) {
					j++;
				} else if (count == 0) {
					while (count == 0) {
						c = s.charAt(i);
						if (map.containsKey(c)) {
							map.put(c, map.get(c)+1);
							if(map.get(c)>0) {
							    if (res > j - i + 1) {
									res = j - i + 1; 
									ix = i;
									jx = j;
								}
								count++;
							}
						}
						i++;
					}
					j++;
				}
			}
	        if(ix==-1){
	            return "";
	        }
	        StringBuilder sb = new StringBuilder();
			for(int q=ix;q<=jx;q++){
	            sb.append(s.charAt(q));
	        }
	        return sb.toString();

	}
}

