package LinkedList;


public class SwapLL {

	private static ListNode head;
	
	public static void main(String[] args) {
		insertF(5);
		insertF(4);
		insertF(3);
		insertF(2);
		insertF(1);
		display();
		System.out.println();
		
		int k = 2;
		swapNodes(head,k);
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
/*	

	public static ListNode get(int index) {
		ListNode node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	public static ListNode swapNodes(ListNode head, int k) {
		ListNode nodeFromFront = get(k -1);
			    
	    ListNode nodeFromBack = getNodefromBack(head,k);
	    
		// now swap between these 2 nodes 
		//  swap(nodeFromFront, nodeFromBack);
		int temp = nodeFromFront.val;
		nodeFromFront.val= nodeFromBack.val;
		nodeFromBack.val= temp;
		 
		return head;
	}
	public static ListNode getNodefromBack(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
	// since total length is 5 and need 2nd node then 5-2=3 steps fast needs to traverse to make a difference of 2 between fast and slow
		
		for(int i=0; i < n;i++) {
			fast = fast.next;
		}
		if(fast == null) {
			return head.next;
		}
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow.next;
	}
	
	*/
	public static ListNode swapNodes(ListNode head, int k) {
		 ListNode fast = head;
		 
		 // get the kth node from front
		 for(int i=1; i< k; i++) {
			 fast = fast.next;
		 }
		 ListNode current = fast;
		 ListNode slow = head;
		 
		 // Move the slow pointer to get the kth node from back
		 while(current.next != null) {
			 current = current.next;
			 slow = slow.next;
		 }
		 // swap
		int temp = fast.val;
		fast.val = slow.val;
		slow.val = temp;
		return head;
		 
	}
	
}
