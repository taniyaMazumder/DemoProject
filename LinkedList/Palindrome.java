package LinkedList;

public class Palindrome {

	static ListNode head;
	
	public static void main(String[] args) {
		insertF(1);
		insertF(2);
		insertF(2);
		insertF(4);
		display();
		System.out.println();
		System.out.println(isPalindrome(head));
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
	
	public static boolean isPalindrome(ListNode head) {
		ListNode mid = middleNode(head);
		ListNode revHead = rev(mid);
		
		ListNode reRev = revHead;
		while(head != null && revHead != null) {
			if(head.val == revHead.val) {
				head = head.next;
				revHead = revHead.next;
			}else {
				break;
			}
		}
		rev(reRev);
		
		return head ==null || revHead ==null;
		
	}
	
	public static ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static ListNode rev(ListNode head) {
		ListNode prev = null;
		ListNode pres = head;
		ListNode next = pres.next;
		
		while(pres != null) {
			pres.next = prev;
			prev = pres;
			pres= next;
			if(next != null) {
				next = next.next;
			}
		}
		return prev;
	}

}
