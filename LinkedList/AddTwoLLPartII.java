package LinkedList;

import java.util.Stack;

public class AddTwoLLPartII {

	private static ListNode head;
	private static ListNode headA;
	private static ListNode headB;
	
	public static void main(String[] args) {

		
//		Stack<Integer> stack1 = new Stack<>();
//		stack1.add(7);
//		stack1.add(2);
//		stack1.add(4);
//		stack1.add(3);
//		Stack<Integer> stack2 = new Stack<>();
//		stack2.add(5);
//		stack2.add(6);
//		stack2.add(4);
		AddTwoLLPartII list1 = new AddTwoLLPartII();
		
		list1.insertFA(3);
		list1.insertFA(4);
		list1.insertFA(2);
		list1.displayA();
		System.out.println();
		
		AddTwoLLPartII list2 = new AddTwoLLPartII();
		
		list2.insertFB(4);
		list2.insertFB(6);
		list2.insertFB(5);
		list2.displayB();
		System.out.println();
		
		addTwoNumbers2(list1.headA, list2.headB);
		display();
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
	public static void insertFA(int val) {
		ListNode newN = new ListNode(val);
		newN.next = headA;
		headA = newN;
	}
	public static void insertFB(int val) {
		ListNode newN = new ListNode(val);
		newN.next = headB;
		headB = newN;
	}
	public static void displayA() {
		ListNode temp = headA;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	public static void displayB() {
		ListNode temp = headB;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	public static void display() {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	
// Solution-1:
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry =0;
        
        while(l1!= null || l2 != null) {
        	int sum =0 + carry;
        	
        	if(l1 != null) {
        		sum += l1.val;
        		l1 = l1.next;
        	}
        	if(l2 != null) {
        		sum += l2.val;
        		l2 = l2.next;
        	}
        	carry = sum / 10;
        	sum = sum % 10;
        	temp.next = new ListNode(sum);;
        	temp = temp.next;
        }
        if(carry ==1) {
        	temp.next = new ListNode(1);
        }
        	return result.next;	
    }
	
	//Question-2:  Add Two Linked List II
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
		ListNode revHead1 = reverse(l1);
		ListNode revHead2 = reverse(l2);
		ListNode l3 = addTwoNumbers(revHead1, revHead2);
		
		ListNode rereverse = reverse(l3);
		return rereverse;
	}

	// reverse a linked list using Iteration
			public static ListNode reverse(ListNode head) {
				// if list is empty
				if(head == null) {
					return head;
				}
				ListNode prev = null;
				ListNode present = head;
				ListNode next = present.next;
				
				while(present !=null) {
					present.next = prev;
					prev = present;
					present = next;
					if(next != null) {
						next = next.next;
					}
				}
				return prev;
			}
			
	// Solution 2: Using stack
	static ListNode addTwoNumberStack(ListNode list1, ListNode list2) {
		Stack<Integer> stack1 = list2Stack(list1);
		Stack<Integer> stack2 = list2Stack(list2);
		ListNode head = null;
		int carry =0;
		while(!stack1.isEmpty() || !stack2.isEmpty() || carry !=0) {
			int sum = carry;
			if(!stack1.isEmpty()) {
				sum = sum +stack1.pop();
			}
			if(!stack2.isEmpty()) {
				sum = sum +stack2.pop();
			}
			ListNode newNode = new ListNode( sum %10);
			newNode.next = head;
			head = newNode ;
			carry = sum /10;
		}
		return head;
	}
	private static Stack<Integer> list2Stack(ListNode head) {
		ListNode temp = head;
		Stack<Integer> stack = new Stack<>();
		while(temp != null) {
			stack.add(temp.val);
			temp= temp.next;
		}
		return stack;
	}
	
}
