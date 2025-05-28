// delete middle element from stack using recursion
package Recursion;

import java.util.Stack;

public class DeleteMidElementFromStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static Stack<Integer> removeMid(Stack<Integer> s, int size){
		
		if(size == 0) {
			return s;
		}
		int k = (size /2 )+1;
		solve(s,k);
		return s;
	}
	private static void solve(Stack<Integer> s, int k) {
		// base condition
		if(k ==1) {
			s.pop();
			return ;
		}
		int temp = s.peek();
		s.pop();
		
		solve(s, k-1);
		s.push(temp);
		
	}

}
