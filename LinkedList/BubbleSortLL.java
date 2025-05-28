 package LinkedList;

public class BubbleSortLL {

	private static ListNode head;
	private static ListNode tail;
	private static int size;
	public static void main(String[] args) {
		BubbleSortLL bb = new BubbleSortLL();
		
		for (int i = 7; i >0; i--) {
			bb.insertLast(i);
		}
		bb.display();
		bb.bubbleSort();
		bb.display();

	}
	public BubbleSortLL() {
		size = 0;
	}
	public static void insertFirst(int val) {
		ListNode node = new ListNode(val);
		node.next = head;
		head = node;
				
		if(tail == null) {
			tail = head;
		}
		size += 1;
	}
	public static void insertLast(int val) {
		if(tail == null) {
			insertFirst(val);
			return;
		}
		ListNode node = new ListNode(val);
		tail.next = node;
		node.next = null;
		tail = node;
		size += 1;
	}
	public static void bubbleSort() {
		bubbleSort(size -1, 0);
	}
	static void bubbleSort(int row, int col) {
		if(row ==0) {
			return;
		}
		if(col < row) {
			ListNode f= find(col);
			ListNode s = find(col+1);
			
			if(f.val > s.val) {
				// swap
				if(f == head) {
					head =s;
					f.next = s.next;
					s.next = f;
				}
				
			 else if(s == tail) {
				ListNode prev = find(col -1);
				prev.next = s;
				tail =f;
				f.next = null;
				s.next = tail;
				
			} else {
				ListNode prev = find(col -1);
				prev.next = s;
				f.next = s.next;
				s.next = f;
			}
		}
			bubbleSort(row , col+1);
		} else {
			bubbleSort(row -1 , 0);
		}
	}
	public static ListNode find(int value) {
		ListNode node = head;
		if(node.val == value) {
			return node;
		}
		node = node.next;
		return null;
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
		
		
	}

}
