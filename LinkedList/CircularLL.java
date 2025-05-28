package LinkedList;

public class CircularLL {

	private static ListNode head;
	private static ListNode tail;
	
	public static void main(String[] args) {
		insertFirst(23);
		insertFirst(2);
		insertFirst(46);
		insertFirst(78);
		display();
		System.out.println();
		insertFirst(43);
		display();
		System.out.println();
		insertLast(25);
		display();
		System.out.println();
		insertMid(4,85);
		display();
		System.out.println();
		deleteMid(5);
		display();
	}

	public CircularLL() {
		
	}
	public static void display() {
		ListNode temp = head;
		if(head != null) {
			do {
				System.out.print(temp.val + "->");
				temp = temp.next;
				
			}while(temp != head); 
		}
		System.out.print("START");
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
	}
	
	public static void insertFirst(int val) {
		
		ListNode node = new ListNode(val);
		if(head == null) {
			head = node;
			tail =node;
		}
		tail.next = node;
		node.next = head;
		tail= node;
		
	}
	public static void delete(int val) {
		ListNode node = head;
		if(node == null) {
			return;
		}
		if(node.val == val) {
			head = head.next;
			tail.next = head;
			return;
		}
		do {
			ListNode n = node.next;
			if(n.val == val) {
				node.next = n.next;
				break;
			}
			node = node.next;
		} while(node != head); 
	}
	// insertion at front 
//		public static void insertionFront(int val) {
//				ListNode newNode = new ListNode(val);
//				ListNode tail = head;
//				while(temp != head.next) {
//					temp = temp.next;
//				}
//				
////				temp.next = newNode;
////				newNode.next = head;
////				temp = newNode;
//				
//				newNode.next = temp.next ;
//				temp.next = newNode;
//				temp = temp.next;
//				
//			}
	// 2nd way - insertion at first
	public static void insertionFirstCLL(int val) {
		ListNode node = new ListNode(val);
		node.next = head;
		head = node;
		tail.next = node;
	}
	// insert at last
	static void insertLast(int val) {
//		ListNode node = new ListNode(val);
//		tail.next = node;
//		tail = node;
//		node.next = head;
		
		ListNode node = new ListNode(val);
		if(head == null) {
			head = node;
			tail =node;
		}
		tail.next = node;
		node.next = head;
		tail= node;
	}
	// insert at middle- similar to singly LL
	static void insertMid(int index , int val) {
//		ListNode node = new ListNode(val);
//		ListNode temp = head;
//		for (int i = 0; i < index -1; i++) {
//			temp = temp.next;
//		}
//		node.next = temp.next;
//		temp.next = node;
		ListNode temp = head;
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		ListNode node = new ListNode(val);
		node.next = temp.next;
		temp.next = node;
		temp = node;
		
	}
	// deletion from first
	static void deleteFirst() {
		ListNode temp = head;
		temp = temp.next;
		head = temp;
		tail.next = head;
	}
	// deletion from first -sol2
		static void deleteFirst2() {
			head = head.next;
			tail.next = head;
		}
	// deletion from last
	void deleteLast() {
		ListNode temp = head;
		ListNode ptr = temp.next;
		
		while(ptr.next != head) {
			temp = ptr;
			ptr = ptr.next;
		}
		temp.next = head;
		tail = temp;
	}
	// deletion from last-sol2
		static void deleteLast2() {
			ListNode temp = head;
			while(temp.next != tail) {
				temp = temp.next;
			}
			temp.next = head;
			tail = temp;
		}
	// deletion from middle - similar to singly LL
	static void deleteMid(int index) {
		ListNode temp = head;
		ListNode ptr = temp.next;
		
		for(int i =1; i< index-1;i++) {
			temp = ptr;
			ptr = ptr.next;
		}
		temp.next = ptr.next;
	}
	
}
