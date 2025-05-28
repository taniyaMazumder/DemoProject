// Given a string e.g. asaasass , output will be asa2sas2. when a char occurs once then it stored in a string , and if it occurs more than once then
//stored the char followed by the occurrence number.

package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ServiceNowQuestion1 {

	public static void main(String[] args) {
		String s ="asaasass";
		System.out.println(solution2usingStack(s));
	}
/*
	static String solution(String s) {
		StringBuilder sb = new StringBuilder(s);
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<sb.length();i++) {
			char ch = sb.charAt(i);
			if( i< sb.length()-1 && ch == sb.charAt(i +1)) {
				if(map.containsKey(ch)) {
					map.put(ch, map.get(ch) +1);
				}
			}
		}
		return s;
		
	}
	*/
	static String solution2usingStack(String s) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Integer> map = new HashMap<>();
		int count =1;
		StringBuilder sb = new StringBuilder(s);
		StringBuilder answer = new StringBuilder();
	//	String ans = sb.toString();
	
		stack.add(s.charAt(0));
				for(int i=1; i<s.length();i++) {
					char ch = s.charAt(i);
					
					if(ch != stack.peek()) {
						stack.add(ch);
					}
					else {
//						if(map.containsKey(ch)) {
//							map.put(ch, map.get(ch)+1);
//						}
//						else {
//							map.put(ch, 1);
//						}
						map.put(ch, count+1);
					}
				}
				
				while(!stack.isEmpty()) {
					for(int j=s.length() -1; j>0;j--) {
					char ch2 = stack.pop();
					int temp=0;
					char ch3 = s.charAt(j);
					if(map.containsKey(ch2) && ch2 ==ch3) {
						for(Map.Entry<Character, Integer> entry:map.entrySet()){
						    //System.out.print(entry.getKey() + " : " + entry.getValue());
							if(entry.getKey() == ch2) {
								temp = (int) entry.getValue() ;
							}
						}
						map.remove(ch2);
					}
					
//					sb.append(ch2); 
			//		ans = ch2 +"";
					answer.append(ch2);
					
					if(temp !=0) {
//						sb.append(temp);
			//			ans += temp +"";
						answer.append(temp);
					}
					//ans= ch2 +""+ temp ;
				}
				}	
				return answer.toString();
	}
}
