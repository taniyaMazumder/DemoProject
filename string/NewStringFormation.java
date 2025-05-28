// Take a string e.g. asaasass , output will be asa2sas2. when a char occurs once then it stored in a string , and if it occurs more than once then
//stored the char followed by the occurrence number

package string;

import java.util.HashMap;
import java.util.Map;

public class NewStringFormation {

	public static void main(String[] args) {
		String s = "asaasasss";
		//	String s = "aaassss";
		System.out.println(strFormation(s));

	}
	public static String strFormation(String str) {
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
	
//		for (int i = 0; i < str.length() -1; i++) {
//			if(str.charAt(i) != str.charAt(i +1)) {
//				sb.append(str.charAt(i));
//			} else {
////					int count =1;
////					map.put(str.charAt(i), ++count);
////					i++;
////			
////					for(Map.Entry<Character, Integer> entry : map.entrySet()) {
////						sb.append(entry.getKey() + ""+ entry.getValue());
////						map.remove(entry.getKey(), entry.getValue());
////					}
////				char[] charArray = str.toCharArray();
////				for(char c: charArray) {
//					if(map.containsKey(str.charAt(i))) {
//					    map.put(str.charAt(i), map.get(str.charAt(i)) +1);
//					 // Getting the values from the Map and store it in string
//				        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//				        	sb.append(entry.getKey() + ""+ entry.getValue());
//				        	map.remove(entry.getKey(), entry.getValue());
//				        }
//					} else {
//						map.put(str.charAt(i), 1);
//					}
//				}
//				
//			//}
//			
//		}
		
		for (int i = 0; i < str.length() -1; i++) {
			if(str.charAt(i) != str.charAt(i +1)) {
				sb.append(str.charAt(i));
			} else {
				if(map1.containsKey(str.charAt(i))) {
					map1.put(str.charAt(i), map1.get(str.charAt(i)) +1);
				} else {
					map2.put(str.charAt(i), 1);
				}
				for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
		        	sb.append(entry.getKey() + ""+ entry.getValue());
		        	map1.remove(entry.getKey(), entry.getValue());
		        }
			}
		}
		return sb.toString();
	}
	
	
	/*	public static String findOcc(String str) {
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap<>();
		
		char[] charArray = str.toCharArray();
		for(char c: charArray) {
			if(map.containsKey(c)) {
			    map.put(c, map.get(c) +1);
			} else {
				map.put(c, 1);
			}
		}
		// Printing the charCountMap
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        	sb.append(entry.getKey() + ""+ entry.getValue());
        }
		return sb.toString();
	}
*/
}
