 package LinkedList;

public class ReverseLLInRange {

	private static ListNode head;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static class ListNode {
		private int val;
		private ListNode next;
		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
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
	
	public ListNode reverseBetween(ListNode head, int left, int right) {
        
		if(left == right) {
			return head;
		}
		ListNode current = head;
		ListNode prev = null;
		
		
		for (int i = 0; current != null && i < (left -1); i++) {
			prev = current;
			current = current.next;
		}
		ListNode last= prev;
		ListNode newEnd = current;
		
		// now reverse
		ListNode next = current.next;
		for (int i = 0; current != null && i < right - left +1; i++) {
			current.next = prev;
			prev = current;
			current = next;
			if(next != null) {
				next = next.next;
			}
		}
		if(last != null) {
			last.next = prev;
		}else {
			head = prev;
		}
		newEnd.next = current;
		return head;
    }

}
