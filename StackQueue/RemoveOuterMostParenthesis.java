// Intuition - Take a blank stringBuilder to append two string
package StackQueue;

import java.util.Stack;

public class RemoveOuterMostParenthesis {

	public static void main(String[] args) {
	//	String s = "(()())(())";
		String s = "(()())(())(()(()))";
		System.out.println(removeOuterParentheses(s));

	}
/* Applicable for 1 input only
 * 
	public static String removeOuterParentheses(String s) {
        
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder(""); // take a blank string to return answer
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				if(stack.isEmpty() || stack.peek() != s.charAt(i)) {
					sb.append(s.charAt(i));
					stack.push(s.charAt(i));
				} 
			} else {
				if(!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
					sb.append(s.charAt(i));
					
				}
			}
			
		}
		return sb.toString();
		
    }
*/	
	public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder(""); // taking a blank string builder to append
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				if(stack.size() > 0) {
					sb.append(s.charAt(i));
				}
				stack.push(s.charAt(i));
			}
			else {
				stack.pop();
				if(stack.size() > 0) {
					sb.append(s.charAt(i));
				}
			}
		  }
		 return sb.toString();
		}
}
