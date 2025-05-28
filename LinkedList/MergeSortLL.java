package LinkedList;

public class MergeSortLL {

	static ListNode head;
	public static void main(String[] args) {
		insertFirst(3);
		insertFirst(1);
		insertFirst(2);
		insertFirst(4);
		
		display();
		System.out.println();
		
		sortList(head);
		display();
	}
	
	static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
		
	}

	public static void insertFirst(int val) {
		ListNode node = new ListNode(val);
		node.next = head;
		head = node;
		
	}
	
	static ListNode merge(ListNode list1, ListNode list2) {
	        ListNode dummyHead = new ListNode();
	        ListNode tail = dummyHead;
	        while (list1 != null && list2 != null) {
	            if (list1.val < list2.val) {
	                tail.next = list1;
	                list1 = list1.next;
	                tail = tail.next;
	            } else {
	                tail.next = list2;
	                list2 = list2.next;
	                tail = tail.next;
	            }
	        }
	        tail.next = (list1 != null) ? list1 : list2;
	        return dummyHead.next;
	    }
	static ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
	// Another way to find getMid before mid to break the LL into 2 parts
	static ListNode getMid2(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode temp = head;
		
		while(fast != null && fast.next != null) {
			temp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		temp.next = null; //breaking the list into half, i.e., the list breaks just before mid
		return slow; //Note: temp keeps track of the node just before mid (slow) so the first half will be head to temp and second half will be slow to fast
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
		
		public ListNode() {
			super();
		}

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
