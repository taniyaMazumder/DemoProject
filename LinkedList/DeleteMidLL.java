package LinkedList;

public class DeleteMidLL {
	
	private static ListNode head;
	
	public static void main(String[] args) {
//		insertF(6);
//		insertF(2);
//		insertF(1);
//		insertF(7);
//		insertF(4);
//		insertF(3);
//		insertF(1);
		insertF(4);
		insertF(3);
		insertF(2);
		insertF(1);
		display();
		System.out.println();
		
		deleteMiddle(head);
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
	public static ListNode deleteMiddle(ListNode head) {
		if(head==null || head.next==null) return null;
        // Find length of LL
        ListNode temp = head;
        int len =1;

        while(temp.next != null) {
            temp = temp.next;
            len++;
        }
        int mid = len /2;

        ListNode prev = get(head, mid-1);
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
        return head;
    }
    public static ListNode get(ListNode head, int index) {
		ListNode node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

    // Another way - done by me - TC- O(n) , sc- O(1)
    public static ListNode deleteMiddle2(ListNode head) {
        
        ListNode middle = mid(head);
        if(head == middle) {
            return null;
        }
        ListNode current = head;
        ListNode prev =null;
        while(current != null) {
            if(current != middle) {
                prev = current;
                current = current.next;
            } 
            else {
            	prev.next = current.next;
                break;
            }
        }
          return head;
    }
    public static ListNode mid(ListNode head) {
	        ListNode fast = head;
	        ListNode slow = head;

	        while(fast != null && fast.next != null) {
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        return slow;
	    }
}
