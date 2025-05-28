 package LinkedList;

public class ReorderLL {

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
	public void reorderList(ListNode head) {
		
        ListNode mid = middle(head);
        
        ListNode revHead = reverse(mid);
        
        ListNode hf = head;
        ListNode hs= revHead;
        
        while(hf != null && hs != null) {
        	ListNode temp = hf.next;
        	hf.next = hs;
        	hf = temp;
        	
        	temp = hs.next;
        	hs.next = hf;
        	hs = temp;
        }
        if(hf != null) {
        	hf.next = null;
        }
    }
	
	public static ListNode middle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	public static ListNode reverse(ListNode head) {
		
		ListNode present = head;
		ListNode prev= null;
		ListNode next = present.next;
		
		while(present != null) {
			present.next = prev;
			prev = present;
			present = next;
			if(next != null) {
				next = next.next;
			}
		}
		return prev;
	}

}
