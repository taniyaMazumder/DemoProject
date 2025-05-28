package LinkedList;


public class AddTwoListGFG {
	private static Node head;
	private static Node headA;
	private static Node headB;
	
	public static void main(String[] args) {
		AddTwoListGFG list1 = new AddTwoListGFG();
		
		list1.insertFA(7);
		list1.insertFA(3);
		list1.insertFA(1);
		list1.insertFA(4);
		list1.displayA();
		System.out.println();
		
		AddTwoListGFG list2 = new AddTwoListGFG();
		
		list2.insertFB(2);
		list2.insertFB(7);
		list2.insertFB(9);
		list2.displayB();
		System.out.println();
		
		addTwoNumbers(list1.headA, list2.headB);
		display();
	}
	private static class Node {
		private int data;
		private Node next;
		public Node(int val, Node next) {
			super();
			this.data = val;
			this.next = next;
		}
		public Node() {
			
		}
		public Node(int val) {
			super();
			this.data = val;
		}
	}
	public static void insertFA(int val) {
		Node newN = new Node(val);
		newN.next = headA;
		headA = newN;
	}
	public static void insertFB(int val) {
		Node newN = new Node(val);
		newN.next = headB;
		headB = newN;
	}
	public static void displayA() {
		Node temp = headA;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	public static void displayB() {
		Node temp = headB;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	public static void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	public static Node addTwoNumbers(Node l1, Node l2) {
		// edge cases
		if(l1 == null) {
			return l2;
		}
		else if(l2 == null) {
			return l1;
		}
		Node revHead1 = reverse(l1);
		Node revHead2 = reverse(l2);
		int carry =0;
		Node ans = null;
		
		while(revHead1!= null || revHead2!= null) {
			int val1 = revHead1 != null ? revHead1.data : 0;
			int val2 = revHead2 != null ? revHead2.data : 0;
			
			int sum = val1 + val2+  carry;
			
			carry = sum /10;
			
			int digit = sum% 10;
			
			Node node = new Node(digit);
			
			if(ans == null) {
				ans = node;
			} else {
				node.next = ans;
				ans = node;
			}
			revHead1 = revHead1 != null ? revHead1.next : null;
			revHead2 = revHead2 != null ? revHead2.next : null;
		}	
			if(carry > 0) {
				Node node2 = new Node(carry);
				
				if(ans == null) {
					ans = node2;
				} else {
					node2.next = ans;
					ans = node2;
				}
			}
			return ans;
			
		}
	
	static Node reverse(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node prev = null;
		Node current = head;
		
		Node next = current.next;
		
		while(current!= null) {
			current.next = prev;
			prev = current;
			current = next;
			if(next!= null) {
				next = next.next;
			}
		}
		return prev;
	}
}
