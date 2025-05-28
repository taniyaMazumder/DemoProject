package StackQueue;

import java.util.Stack;

public class LongestValidParenthesis {

	public static void main(String[] args) {
	//	String s ="(()";
		String s =")()())";
		System.out.println(longestValidParentheses(s));
	}

	// using stack, TC-O(n), SC-O(n)
	public static int longestValidParentheses(String s) {
		int maxLen = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<>(); // to store the index of string
		stack.push(-1);// first index of stack is -1.
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			}else {
				stack.pop();
				if(stack.size() == 0) {
					stack.push(i);
				}
			}
			maxLen = Math.max(maxLen, i - stack.peek());
			}
		return maxLen;
		}
	
 // using two pointer - TC-O(n) SC-O(1)
	static int findLenValidParenthesis(String t) {
		int open =0, closed = 0;
		int max =0;
		//iterate from 0 to n
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			if(ch == '(') {
				open++;
			}
			else {
				closed++;
			}
			if(open == closed) {
				int len = open + closed;
				max = Math.max(len, max);
			}
			else if(closed > open) {
				open = closed =0;
			}
		}
		// iterate from n to 0
		open =closed = 0;
		for (int i = t.length() -1; i >=0; i--) {
			char ch = t.charAt(i);
			if(ch == '(') {
				open++;
			}
			else {
				closed++;
			}
			if(open == closed) {
				int len = open + closed;
				max = Math.max(len, max);
			}
			else if(open > closed) {
				open = closed =0;
			}
		}
		return max;
	}
}


