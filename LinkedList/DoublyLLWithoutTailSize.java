package LinkedList;

import LinkedList.DoublyLL.ListNode;


public class DoublyLLWithoutTailSize {

	private static ListNode head;
	public static void main(String[] args) {
		insertFirst(78);
		insertFirst(55);
		insertFirst(12);
		insertFirst(21);
		insertFirst(5);
		display();
		System.out.println();
	//	insertLast(29);
		display();
		System.out.println();
	//	insertMiddle(100,2);
		display();
		System.out.println();
		deleteMiddle2(3);
		display();
	}
	public DoublyLLWithoutTailSize() {
		
	}
	// insertFirst
	static void insertFirst(int val) {
		
		ListNode newNode = new ListNode(val);
		newNode.next = head;
		newNode.prev = null;
		if(head !=null) {
			head.prev = newNode;
		}
		head = newNode ;
	}
	
	// insert last
	static void insertLast(int val) {
		ListNode temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		ListNode newNode = new ListNode(val);
		temp.next = newNode;
		newNode.prev = temp;
		newNode.next = null;
	}
	
	static void insertMiddle(int val, int index) {
		ListNode temp = head;
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}
		ListNode node = new ListNode(val);
		node.next = temp.next;
		temp.next = node;
		node.prev = temp;
		temp.next.next = node.next;

	}
	
	public static void deleteLast() {
		// Another way to delete from last
//		ListNode temp = head;
//		while(temp.next != null) {
//			temp = temp.next;
//			
//		}
//		ListNode ptr = temp.prev ;
//		ptr.next = null;
	//Another way to delete from last
		ListNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.prev.next = null;
	}
	public static void deleteMiddle(int index) {
		ListNode ptr = head;
		ListNode temp = ptr.prev;
		
		for(int i=1; i< index -1; i++) {  
			temp = ptr; 	// temp will be pointing out the prev node of that node what we want to delete
			ptr = ptr.next; // ptr will be pointing out the node what we want to delete
		}
		temp.next = ptr.next ;
		ptr.next.prev = temp;
	}
	public static void deleteMiddle2(int index) {
		ListNode temp = head;
		
		for(int i=0; i<index;i++) {
			temp = temp.next;
		}
		temp.prev.next = temp.next;
	}
	public static void display() {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	public static class ListNode {
		private int val;
		private ListNode next;
		private ListNode prev;
		
		public ListNode(int val) {
			super();
			this.val = val;
		}
		
		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}

		public ListNode(int val, ListNode next, ListNode prev) {
			super();
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
	}
}
