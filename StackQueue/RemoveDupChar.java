package StackQueue;

import java.util.Stack;

public class RemoveDupChar {

	public static void main(String[] args) {
		String s = "abbaca";
		System.out.println(removeDuplicates2(s));
	}
 // TC- O(n) - SC- O(n) since took stack
	public static String removeDuplicates(String s) {
     Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
        	if(stack.isEmpty() || stack.peek() != s.charAt(i)) {
        		stack.push(s.charAt(i));
        	}
        	else {
        		stack.pop();
        	}
        }
        // returning string answer
        StringBuilder sb = new StringBuilder(""); // taking a blank string builder to append
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
     }
	// Another way for better solution without using stack
	public static String removeDuplicates2(String s) {
		StringBuilder sb = new StringBuilder();
		for(char ch : s.toCharArray()) {
			// if the current character is same as the last one in `sb`
            // then we cannot push it to `sb`
            // we remove the one in `sb`
			if(sb.length() >0 && sb.charAt(sb.length() -1) == ch) {
				sb.deleteCharAt(sb.length() -1);
			}
			else {
				sb.append(ch);
			}
		}
		return sb.toString();
		
	}
}
