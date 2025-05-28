package LinkedList;

public class RevreseKGroup {

	private static ListNode head;
	
	public static void main(String[] args) {
		insertF(7);
		insertF(6);
		insertF(5);
		insertF(4);
		insertF(3);
		insertF(2);
		insertF(1);
		display();
		System.out.println();
		int k=2;
		reverseKgroup(head,k);
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
	static ListNode reverseKgroup(ListNode head, int k) {
		if(k == 1 || head == null){
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        int remaininglength = listLength(head);

        while(remaininglength >= k){

            ListNode last = prev;
            ListNode newEnd = current;

            ListNode next = current.next;

            for(int i = 0; (current!= null) && i < k; i++){
                current.next = prev;
                prev = current;
                current = next;
                next = (next != null) ? next.next : next;
            }

            if(last == null){
                head = prev;   
            } else{
                last.next = prev;
            }

            newEnd.next = current;
            prev = newEnd;

            remaininglength = remaininglength - k;
        }
        return head;
    }

   //finding the length of the List
   public static int listLength(ListNode head){
        if(head == null){
            return 0;
        }

        ListNode temp = head;
        int length = 0;

        while(temp != null){
            length += 1;
            temp = temp.next; 
        }
        return length;
    }
/*
 * ------------------------------------------------------------------------------------------------------------------------------
 * Reverse K group- Leetcode - Another way
 */
   static ListNode reverseKgroup2(ListNode head, int k) {
	   if(k <=1 || head == null) {
		   return head;
	   }
	   ListNode current  = head;
	   ListNode prev = null;
	   
	   
	   
	   while(true) {
		   ListNode last = prev;
		   ListNode newEnd = current;
		   ListNode next = current.next;
		   
		   for(int i=0; current != null && i<k;i++) {
			  current.next = prev;
			  prev = current;
			  current = next;
			  
			  if(next != null) {
				  next = next.next;
			  }
		}
		   if(last != null) {
			   last.next = prev;
		   }
		   else {
			   head = prev;
		   }
		   newEnd.next = current;
		   
		   if(current == null) { // this has been taken to break the while loop
			   break;
		   }
		   prev = newEnd;
	   }
	   return head;
   }
   
   
   
   
	// reverse the alternate K nodes
	static ListNode reverseAlterKgroup(ListNode head, int k) {
		if(k <=0 || head == null ) {
            return head;
        }
		ListNode current = head;
		ListNode prev = null;
		
		while(current != null) {
			ListNode last = prev;
			ListNode newEnd = current;
			ListNode next = current.next;
			// now reverse
			for (int i = 0; current != null && i < k ; i++) {
				current.next = prev;
				prev = current;
				current = next;
				if(next != null) {
					next = next.next;
				}
			}
			if(last != null) {
				last.next = prev;
			}else {
				head = prev;
			}
			newEnd.next = current;
			// skip the k nodes
			for (int j = 0; current != null && j < k ; j++) {
				prev = current;
				current = current.next;
			}
		}
		return head;
	}
	
}
