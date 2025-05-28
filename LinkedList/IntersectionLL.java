package LinkedList;

public class IntersectionLL {

	private static ListNode head;
	
	public static void main(String[] args) {
		IntersectionLL listA = new IntersectionLL();
		listA.insertF(5);
		listA.insertF(4);
		listA.insertF(8);
		listA.insertF(1);
		listA.insertF(4);
		display();
		System.out.println();
		IntersectionLL listB = new IntersectionLL();
		listB.insertF(5);
		listB.insertF(4);
		listB.insertF(8);
		listB.insertF(1);
		listB.insertF(6);
		listB.insertF(5);
		display();
		
		System.out.println();
		
		System.out.println(getIntersectionNode2(listA.head,listB.head));
		
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
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode ans = head;
		int lengthA = lengthLL(headA);
		int lengthB = lengthLL(headB);
		
		if(lengthA > lengthB) {
			ListNode fast= headA;
	        ListNode slow = headB;
	        
	        while(fast != null && fast.next != null) {
	        	fast = fast.next.next;
	        	slow = slow.next;
                if(fast == slow) {
                    ans = slow;
                }
	        }
		} else {
			ListNode slow= headA;
	        ListNode fast = headB;
	        
	        while(fast != null && fast.next != null) {
	        	fast = fast.next.next;
	        	slow = slow.next;
                if(fast == slow) {
                    ans = slow;
                }
	        }
		}
		return ans;
 }
	private static int lengthLL(ListNode head) {
		int length =0;
		ListNode temp = head;
		while(temp != null) {
			temp = temp.next;
			length++;
		}
		
		return length;
	}
	
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
	if(headA == null || headB == null) {
		return null;
	}
	ListNode first = headA;
	ListNode second= headB ;
	
	while(first != second) {  // loop will continue till both the nodes become same
		if(first == null) {
			first = headB;
		} else {
		first = first.next;
		}
		if(second == null) {
			second = headA;
		} else {
			second = second.next;
		}
		
	}
	 return first;
}
}
