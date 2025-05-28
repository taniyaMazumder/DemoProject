package PracticeForInterview;

import java.util.Stack;

public class StackQueue {

	public static void main(String[] args) {
	//	String s = "()[]{}";
		String s = "(()))";
		System.out.println(minInsertion(s));

	}

	static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c: s.toCharArray()) {
			if(c== '(' || c== '{'|| c== '[') {
				stack.push(c);
			} else {
				if(c==')') {
					if(stack.isEmpty()||stack.pop()!='(') {
						return false;
					}
				} else if(c=='}') {
					if(stack.isEmpty()||stack.pop()!='{') {
						return false;
					}
				} else if(c==']') {
					if(stack.isEmpty()||stack.pop()!='[') {
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
	}
	/*
	 * valid parenthesis
	 */
	static int minIns(String s) {
		Stack<Character> stack = new Stack<>();
		for(char ch : s.toCharArray()) {
			if(ch == ')') {
				if(!stack.isEmpty() && stack.peek() =='(') {
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
	/*
	 * min insertion to make balance
	 */
	static int minInsertion(String s) {
		Stack<Character> stack = new Stack<>();
		char open ='(';
		char closed =')';
		int count =0;
		
		for(int i=0;i<s.length();i++) {
//			if(s.charAt(i) == closed)	{
//				if(i<s.length()-1 && s.charAt(i+1) == closed) {
//					if(stack.peek() == open) {
//						stack.pop();
//					} else {
//						count++;
//					}
//				}
//		      }
//			else {
//				stack.push(open);
//			}
			char ch = s.charAt(i);
			if(ch == '(') {
				stack.push(ch);
			}
			else {
				if(i<s.length() -1 && s.charAt(i+1) == ')') {
						i++;
				} else {
					count++;
				}
				if(!stack.isEmpty()) {
					stack.pop();
				}
				else {
					count++;
				}
			 }
			
		}
		return count;
		
	}
	/*
	 * removeoutermost parethesis
	 * 
	 */
	static String remove(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder("");
		
		for (int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == '(') {
				if(stack.size() >0) {
					sb.append(s.charAt(i));
				}else {
					stack.push(s.charAt(i));
				}
			} else {
				stack.pop();
				if(stack.size() >0) {
					sb.append(s.charAt(i));
				}
			}
		}
		return sb.toString();
	}
}
