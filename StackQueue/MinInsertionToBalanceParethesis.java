package StackQueue;

import java.util.Stack;

public class MinInsertionToBalanceParethesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int minInsertions(String s) {
		Stack<Character> stack = new Stack<>();
		char open = '(';
		char closed = ')';
		int count=0;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)== closed) {
				if(s.charAt(i +1)== closed) {
					if(stack.peek() == open) {
						stack.pop();
					} else {
						count++;
					}
				}
			} else {
				stack.push(open);
			}
		}
		return count;
    }
}
