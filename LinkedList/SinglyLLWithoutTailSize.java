package LinkedList;


public class SinglyLLWithoutTailSize {

	private static ListNode head;
	public static void main(String[] args) {
		SinglyLLWithoutTailSize list = new SinglyLLWithoutTailSize();
	//	list.insertFirst(12);
	//	list.insertFirst(5);
	//	list.insertFirst(20);
	//	list.display();
	//	list.insertLast(25);
		list.insertFirst(74);
		list.insertFirst(48);
		list.insertFirst(13);
		list.insertFirst(6);
		list.insertFirst(8);
		list.insertFirst(5);
		System.out.println();
		list.display();
	//	list.insertMiddleIndex(100, 3);
	//	list.addMiddSLL(56, 3);
		list.deleteMiddle2(4);
		System.out.println();
		list.display();
//		System.out.println();
		/*	list.deleteFirst();
		System.out.println();
		list.display();
		list.deleteLast();
		System.out.println();
		list.display();
		
		list.deleteMiddle2(3);
		System.out.println();
		list.display(); 
		System.out.println(); */
		
	}
	public SinglyLLWithoutTailSize() {
		
	}
   // insert first
	public static ListNode insertFirst(int val) {
		
		ListNode node = new ListNode(val);
		
		node.next = head;
		head = node ;
		
		return head;
	}
	// insert last
	static ListNode insertLast(int val) {
		ListNode node = new ListNode(val);
		if(head== null) {
			head = node;
		}
		ListNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = node;
		node.next = null;
		return head;
	}
	// insert after a value of node given node 
		static void insertMiddleIndex(int val, int index) {
			ListNode temp = head;
			for (int i = 1; i < index; i++) {
				temp = temp.next;
			}
			ListNode node = new ListNode(val,temp.next);
			temp.next = node;
		}
	
	// get index
	static ListNode getIndex(int index) {
		ListNode temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	// another way to find insert middle, let's say index has been given as pos
	static void insertMidPos(int val, int pos) {
		ListNode temp = head;
		for(int i=0; i<pos -1;i++) {
			   temp = temp.next;
		} 
		ListNode node = new ListNode(val);
		ListNode ptr = temp.next; // storing the previous temp.next value in temporary node
		temp.next = node;
		temp = node;
		temp.next = ptr;
		
	}
	static ListNode addMiddSLL(int val, int index) {
		ListNode temp = head; // 5->8->6->13>48->74->null index -3 val=56
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		ListNode node = new ListNode(val);
     	ListNode ptr = temp.next;
		temp.next = node;
		node.next = ptr;
		return head;
	}
	//delete first
	static ListNode deleteFirst() {
		head = head.next;
		return head;
	}
	// delete last
	static void deleteLast() {
//		Need to take two pointers to get previous node's address
		if(head == null) {
			return;
		}
		ListNode temp = head;
		ListNode ptr= temp.next;
		
		while(ptr.next != null) {
			temp = ptr;
			ptr = ptr.next;
		}
		temp.next = null;
		
	}
	//deleteMiddle
	static void deleteMiddle(int index) {
		ListNode prev= getIndex(index -1);
		prev.next = prev.next.next;
		
	}
	// Another way of deleteMiddle
	static void deleteMiddle2(int index) {
		ListNode temp = head;
		ListNode ptr = temp.next;
		
		for (int i = 0; i < index -2; i++) {
			temp = ptr;
			ptr = ptr.next;
		}
		temp.next = ptr.next;
		
	/*	Another way to delete from middle by index
	 * ListNode ptr = head;
		ListNode temp = ptr.next;
		
		for(int i=0; i<index;i++) {
			ptr = temp;
			temp = temp.next;
		}
		ptr.next = ptr.next.next;
		*/
	}
	static void display() {
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
		public ListNode() {
			
		}
		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}
	}
	
	
}
