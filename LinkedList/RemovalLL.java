package LinkedList;

public class RemovalLL {
	
	private static ListNode head;
	private static int size;

	public static void main(String[] args) {
		RemovalLL list = new RemovalLL();
		list.insertFirst(2);
		list.insertFirst(22);
		list.insertFirst(12);
		list.insertFirst(22);
		list.insertFirst(32);
		list.insertFirst(22);
		list.insertFirst(42);
		
		display();
	/*	System.out.println();
		list.deleteIndex(2);
		display(); */
		System.out.println();
		list.removeElements2(head, 22);
		display();
	}
	
	public RemovalLL() {
		size =0;
	}

	public static void insertFirst(int val) {
		ListNode temp = new ListNode(val);
		temp.next = head;
		head = temp;
		size++;
	}
// remove by index
	public static int deleteIndex(int index) {
		if(index ==0) {
			return head.val;
		}
		ListNode prev = getIndex(index -1);
		prev.next= prev.next.next;
		int value = prev.next.val;
		return value;
		
	}
// remove by value - not checking current node value
	public ListNode removeElements(ListNode head, int val) {
		ListNode temp = head;
		
		while(temp.next != null) {
			if(temp.next.val == val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return temp;
	}
	
	public ListNode removeElements2(ListNode head, int val) {
		ListNode current = head;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode prev = dummy;
		while(current != null) {
			if(current.val == val) {
				prev.next = current.next;
			}
			else {
				prev = current;
			}
			current = current.next;
		}
		return dummy.next;
	}
	public static ListNode getIndex(int index) {
		ListNode temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	public static void display() {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	
	private static class ListNode {
		private int val;
		private ListNode next;
		
		public ListNode(int val) {
			super();
			this.val = val;
		}
		
		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}

		public ListNode() {
			// TODO Auto-generated constructor stub
		}
		
		
	}
}
