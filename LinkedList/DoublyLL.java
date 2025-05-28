package LinkedList;

public class DoublyLL {

	private static ListNode head;
	private static ListNode tail;
	private static int size;
	
	public static void main(String[] args) {
		insertFirstDup(3);
		insertFirstDup(8);
		insertFirstDup(20);
		insertFirstDup(35);
		insertFirstDup(41);
		insertLastDup(100);
		display();
		System.out.println();
		insertMiddleDup(301, 3);
		display();
	}

	public DoublyLL() {
		size = 0;
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
		public static void insertFirstDup(int val) {
			
			ListNode node = new ListNode(val);
			node.next = head;
			node.prev = null;
			if(head !=null) {
				head.prev = node;
			}
			head = node;
			
		}
		public static void insertLastDup(int val) {
			ListNode temp= head;
			while(temp.next != null) {
				temp=temp.next;
			}
			ListNode node = new ListNode(val);
			temp.next = node;
			node.prev = temp;
			node.next =null;
			
		}
		
		public static void insertMiddleDup(int val, int index) {
			ListNode temp = head;
			for (int i = 1; i < index; i++) {
				temp = temp.next;
			}
			ListNode node = new ListNode(val);
			node.next = temp.next;
			temp.next = node;
			node.prev = temp;
			if(node.next !=null) {
				node.next.prev = node;
			}
			
		}
		public static void display() {
			ListNode temp = head;
			while(temp != null) {
				System.out.print(temp.val + "->");
				temp = temp.next;
			}
			System.out.print("END");
		}
		
		public static int deleteFirst() {
			int val = head.val;
			head= head.next;
			head.prev = null;
			return val;
		}
		public static ListNode deleteLast() {
			ListNode temp = head;
			while(temp.next != null) {
				temp = temp.next;
				
			}
			ListNode temp2 = temp.prev;
			temp2.next =null;
			return head;
		}
		public static ListNode deleteMiddle(int index) {
			ListNode prev = head;
			ListNode curr= prev.next;
			
			for(int i=1; i < index -1; i++) {
				
				prev = curr;
				curr = curr.next;
			}
			//curr.prev = prev.next.next;
			prev.next = curr.next;
			curr.next.prev = prev;
			return head;
			
		}
		
		
}
