package LinkedList;

public class FindKthNodeLL {

	private static class Node {
		private int val;
		private Node next;
		
		public Node() {
			super();
		}

		public Node(int val) {
			super();
			this.val = val;
		}
		
		public Node(int val, Node next) {
			super();
			this.val = val;
			this.next = next;
		}
	}
	int getKthFromLast(Node head, int k) {
		if(k ==0 || head == null || head.next == null){
            return 0;
        }
       Node revHead = reverse(head);
       Node present = revHead;
       int len =1;
       while(present != null) {
    	   len++;
    	   present = present.next;
       }
       if(k > len) {
    	   return -1;
       }
       for(int i=0; present != null && i<k-1;i++) {
    	   present = present.next;
       }
       return present.next.val;
       
    }
	Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		Node next = current.next;
		
		while(current != null) {
			current.next = prev;
			prev = current;
			current = next;
			if(next != null) {
				next = next.next;
			}
		}
		return prev;
	}
}
