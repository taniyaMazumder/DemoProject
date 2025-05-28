package LinkedList;

public class SwapInPairsLL {

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
		swapPairs(head);
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

		public static ListNode swapPairs(ListNode head) {
			
			if(head == null){
	            return head;
	        }

	        ListNode prev = null;
	        ListNode current = head;

	        int remaininglength = listLength(head);

	        while(remaininglength >= 2){

	            ListNode last = prev;
	            ListNode newEnd = current;

	            ListNode next = current.next;

	            for(int i = 0; (current!= null) && i < 2; i++){
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

	            remaininglength = remaininglength - 2;
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
        
    
}
