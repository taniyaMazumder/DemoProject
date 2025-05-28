package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLL {

	private static ListNode head;
	public static void main(String[] args) {
		insertF(5);
		insertF(3);
		insertF(4);
		insertF(7);
		insertF(2);

		display();
		System.out.println();
		System.out.println(Arrays.toString(nextLargerNodes(head)));
	}

	private static class ListNode {
		private int val;
		private ListNode next;
		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}
		public ListNode() {
			
		}
		public ListNode(int val) {
			super();
			this.val = val;
		}
	}
	public static void insertF(int val) {
		ListNode newN = new ListNode(val);
		newN.next = head;
		head = newN;
	}
	public static void display() {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	
	public static int[] nextLargerNodes(ListNode head) {
		List<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		
		ListNode current = head;
		while(current != null) {
			list.add(current.val);
			current = current.next;
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			
			while(!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
				result[stack.pop()] = list.get(i);
			}
			stack.push(i);
		}
		return result;
	}
}
