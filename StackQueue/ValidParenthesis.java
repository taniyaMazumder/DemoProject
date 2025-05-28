package StackQueue;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		String s = "(((";
		System.out.println(makeValidParenthesis(s));
	}
	public static int makeValidParenthesis(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(char ch : s.toCharArray()) {
			if(ch == ')') {
				if(!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(ch);
				}
			} else {
				stack.push(ch);
			}
		}
		return stack.size();
	}

}
