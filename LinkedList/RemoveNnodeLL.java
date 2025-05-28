package LinkedList;


public class RemoveNnodeLL {

	private static ListNode head;
	public static void main(String[] args) {
		insertFirst(5);
		insertFirst(4);
		insertFirst(3);
		insertFirst(2);
		insertFirst(1);
		display();
		System.out.println();
		removeNthFromEndMethod3(head,5);
		display();
		System.out.println();
	}
	private static class ListNode {
		private int val;
		private ListNode next;
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
		public ListNode(int val) {
			super();
			this.val = val;
		}
	}
	// insert first
		public static ListNode insertFirst(int val) {
			
			ListNode node = new ListNode(val);
			
			node.next = head;
			head = node ;
			
			return head;
		}

	public static void display() {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
	
	public static ListNode get(int index) {
		ListNode node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	// Method -2: Step 1: Find the length of LL
	// step 2: result =  length- n then if result != temp then result -- otherwise result =0 then traversing will be stop can get prev node 
	// of the node that should be deleted.
	
	public static ListNode removeNthFromEndMethod1(ListNode head, int n) {
		ListNode temp = head;
		int length =1;
		while(temp.next != null) {
			length++;
			temp = temp.next;
		}
		// if we need to remove first element from back then move head = head.next
		if(length == n) {
			head = head.next;
			return head;
		} else {
			int result = length - n;
			temp = head;
			while(temp != null) {
				result --;
				if(result ==0) {
					break;
				} else {
					temp = temp.next;
				}
			}
		}
			if(temp.next != null) {
				temp.next = temp.next.next;
			}
			return head;
		}
	// 2nd method - done by myself TC-0(N) SC- O(1)
	public static ListNode removeNthFromEndMethod2(ListNode head, int n) {
		// if we need to remove first element from back then move head = head.next
		ListNode temp = head;
		int length =1;
		while(temp.next != null) {
			length++;
			temp = temp.next;
		}
		// if we need to remove first element from back then move head = head.next
		if(length == n) {
		//	head = head.next;
			return head.next;
		} else {
			ListNode prev = get(n);
			if(prev.next != null) {
				prev.next = prev.next.next;
			} 
				return head;
		}
	}
	
	//3rd method- TC-O(length of LL) , SC=O(1)
	public static ListNode removeNthFromEndMethod3(ListNode head, int n) {
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
		slow.next = slow.next.next;
		return head;
	}
	
	// Taking two pointer to be optimize the solution
	
	static  ListNode removeNthFromBackTwoPointer(ListNode head, int n) {
            ListNode res = new ListNode(0,head); // value is 0 and res = head
            ListNode dummy = res; // both res and dummy pointing to head
            
            for (int i = 0; i < n; i++) {
                head = head.next;
            }
            
            while(head != null){
            	head = head.next;
            	dummy = dummy.next;
            }
            dummy.next = dummy.next.next;
            return res.next;
            
	}
		// step -1 : reverse the LL
		// Step -2 : remove Nth Node from front
		// Step-3 : rereverse the LL
	static  ListNode removeNthFromBack(ListNode head, int n) {
		ListNode rev = reverse(head);
		ListNode current = head;
		ListNode prev = null;
		
		for(int i =0 ; i<= n; i++) {
			prev = current;
			current = current.next;
		}
		if(current.next != null) {
			prev.next = current.next;
		}
		
		reverse(rev);
		
		return head;
		
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
