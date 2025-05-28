package LinkedList;

public class OddEvenList {

private static ListNode head;
	
	public static void main(String[] args) {
		insertF(5);
		insertF(4);
		insertF(3);
		insertF(2);
		insertF(1);
		display();
		System.out.println();
		oddEvenList(head);
		
		System.out.println();
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

	public static ListNode oddEvenList(ListNode head) {
		ListNode odd_list = new ListNode();
		ListNode odd_ptr = odd_list;
		
		ListNode even_list = new ListNode();
		ListNode even_ptr = even_list;
		
		int index=1;
		while( head != null) {
			if(index %2 !=0) {
				odd_ptr.next = head;
				odd_ptr = odd_ptr.next;
			} else {
				even_ptr.next = head;
				even_ptr = even_ptr.next;
			}
			head = head.next;
			index++;
			
		}
		even_ptr.next = null;
		odd_ptr.next = even_list.next;
		
		return odd_list.next;
	}
}
