package LinkedList;

public class AddTwoLL {

	static ListNode headA;
	static ListNode headB;
	
	public static void main(String[] args) {
//		int a = 4625;
//		System.out.println(reverse(a));
		AddTwoLL list1 = new AddTwoLL();
		
		list1.insertFA(3);
		list1.insertFA(4);
		list1.insertFA(2);
		list1.displayA();
		System.out.println();
		
		AddTwoLL list2 = new AddTwoLL();
		
		list2.insertFB(4);
		list2.insertFB(6);
		list2.insertFB(5);
		list2.displayB();
		System.out.println();
		
		addTwoNumbers(list1.headA, list2.headB);
		
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
	public static void insertFA(int val) {
		ListNode newN = new ListNode(val);
		newN.next = headA;
		headA = newN;
	}
	public static void insertFB(int val) {
		ListNode newN = new ListNode(val);
		newN.next = headB;
		headB = newN;
	}
	public static void displayA() {
		ListNode temp = headA;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	public static void displayB() {
		ListNode temp = headB;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	static int reverse(int num) {
		int rev =0;
		int rem;
		while(num > 0) {
			rem = num % 10;
			rev = rev *10 + rem;
			num = num /10;
		}
		return rev;
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry =0;
        
        while(l1!= null || l2 != null) {
        	int sum =0 + carry;
        	
        	if(l1 != null) {
        		sum += l1.val;
        		l1 = l1.next;
        	}
        	if(l2 != null) {
        		sum += l2.val;
        		l2 = l2.next;
        	}
        	carry = sum / 10;
        	sum = sum % 10;
        	temp.next = new ListNode(sum);
        	temp = temp.next;
        }
        if(carry ==1) {
        	temp.next = new ListNode(1);
        }
        	return result.next;	
    }
	
	//Question-2:  Add Two Linked List II
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
		ListNode revHead1 = reverse(l1);
		ListNode revHead2 = reverse(l2);
		ListNode l3 = addTwoNumbers(revHead1, revHead2);
		
		ListNode rereverse = reverse(l3);
		return rereverse;
	}

	// reverse a linked list using Iteration
			public static ListNode reverse(ListNode head) {
				// if list is empty
				if(head == null) {
					return head;
				}
				ListNode prev = null;
				ListNode present = head;
				ListNode next = present.next;
				
				while(present !=null) {
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
