// Implement queue using two stacks where insertion will be same but deletion will be diff
package StackQueue;

import java.util.Stack;

public class ImplementationQueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static Stack<Integer> st1 = new Stack<>();
	static Stack<Integer> st2 = new Stack<>();
	
	// Insertion efficiency
	// O(1) - Insertion efficiency and O(n) - deletion
	public static void push(int x) {
        st1.add(x);
     }
	public int pop() throws Exception{
		// move all the elements from st1 to st2
		while(!st1.isEmpty()) {
			st2.add(st1.pop());
		}
		
		// now remove the elements from st2 one by one
		int element = st2.pop(); // even if we remove the top element it will store into element variable
		// so the later elements of stack2 move back to st1
		while(!st2.isEmpty()) {
			st1.push(st2.pop());
		}
		return element;
		
	}
	public static int peek() throws Exception{
		while(!st1.isEmpty()) {
			st2.add(st1.pop());
		}
		
		// now remove the elements from st2 one by one
		int element = st2.peek(); // even if we remove the top element it will store into element variable
		// so the later elements of stack2 move back to st1
		while(!st2.isEmpty()) {
			st1.push(st2.pop());
		}
		return element;
    }
	public boolean empty() {
        return st1.isEmpty(); // bcoz we consider first stack as queue
    }
	// Remove efficiency
	// O(n) - Insertion efficiency and O(1) - deletion
	public static void pushRemoveEff(int item) throws Exception{
		while(!st1.isEmpty()) {
			st2.push(st1.pop());
		}
		st1.push(item);
		while(!st2.isEmpty()) {
			st1.push(st2.pop());
		}
	}
	static int peekRemoveEff() {
		return st2.peek();
	}
	public static int popRemoveEff() throws Exception{
		return st1.pop();
		
	}
}
