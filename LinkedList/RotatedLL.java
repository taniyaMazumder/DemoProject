 // Intuition- 1. First find the lastNode then lastNode.next = original head
//2. new Head is = total length of LL - K
//3. newLastnode.next = null

package LinkedList;

public class RotatedLL {

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
	public ListNode rotateRight(ListNode head, int k) {
		if(k <=0 || head == null || head.next == null) {
            return head;
        }
        ListNode lastNode = head;
        int length =1;
         // get a lastnode
        while(lastNode.next != null) {
        	lastNode = lastNode.next;
        	length++;
        }
        
        lastNode.next = head;
        int rotations= k %length ;
        int skip = length - rotations;
        
        ListNode newLast =head;
        
        for(int i =0; i< skip -1;i++) {
        	newLast = newLast.next;
        }
//        ListNode newHead = newLast.next ;
//        head = newHead;
        // these 2 lines can cover 1 line only below
        head = newLast.next ;
        newLast.next = null;
        return head;
    }
}
