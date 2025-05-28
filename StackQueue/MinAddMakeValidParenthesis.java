package StackQueue;

import java.util.Stack;

public class MinAddMakeValidParenthesis {

	public static void main(String[] args) {
		String s = "(((";
		System.out.println(minAddToMakeValid(s));

	}

 public static int minAddToMakeValid(String s) {
	 Stack<Character> stack = new Stack<>();
	 
	 for(char c: s.toCharArray()) {
		 if(c ==')' ) {
			 if(!stack.isEmpty() && stack.peek() == '(') {
				 stack.pop();
					
			 } else {
				  stack.push(c);
			 }
		 } else {
			 stack.push(c);
		 }
	 }
	 return stack.size();
    }
}
