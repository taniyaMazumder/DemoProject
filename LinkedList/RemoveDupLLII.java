package LinkedList;

public class RemoveDupLLII {

private static ListNode head;
	
	public static void main(String[] args) {
		insertF(3);
		insertF(2);
		insertF(1);
		insertF(1);
		insertF(1);
		display();
		System.out.println();
		
		deleteDuplicates(head);
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

	public static ListNode deleteDuplicates(ListNode head) {

		ListNode dummy = new ListNode(0,head); // it's automatically pointing to dummy.next = head;
		ListNode prev = dummy;
		ListNode ptr = head;
		
		while(ptr != null) {
			if(ptr.next != null && ptr.val == ptr.next.val) {
				// skip the nodes those are equal values
				while(ptr.next != null && ptr.val == ptr.next.val) {
					ptr = ptr.next;
				}
				prev.next = ptr.next;
			} else { // if the values are not equal
				prev = prev.next;
			}
			ptr = ptr.next;
		}
		
		return dummy.next;
	}
}
