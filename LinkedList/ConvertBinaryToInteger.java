package LinkedList;


public class ConvertBinaryToInteger {

	static ListNode head;
	public static void main(String[] args) {
	//	int num = 1010;
		insertFirst(1);
		insertLast(0);
		insertLast(1);
		insertLast(0);
		display();
		System.out.println();
		System.out.println(getDecimalValue1(head));

	}
	//solution -1:
	public static int convertBTToInt(int num) {
		int dec_val =0;
		int base =1;
		
		while(num>0) {
			int lastDigit = num %10;
			num = num/10;
			
			dec_val = dec_val + lastDigit * base;
			base = base *2;
		}
		return dec_val;
	}

	public static int getDecimalValue1(ListNode head) {
        ListNode temp = head;
        int dec_val =0;
		int base =1;
		
		
        while(temp != null) {
        	while(temp.val>0) {
        		int lastDigit = temp.val %10;
        		temp.val = temp.val/10;
    			
    			dec_val = dec_val + lastDigit * base;
    			base = base *2;
        	}
        	temp = temp.next;
        }
        return dec_val;
	}   
	// solution-2
	public static int getDecimalValue2(ListNode head) {
        ListNode temp = head;
        int size =0;
        int result =0;
        while(temp != null) {
        	temp= temp.next;
        	size++;
        }
        ListNode ptr = head;
        for (int i = size-1; i >=0; i--) {
        	result = result + ptr.val * (int) Math.pow(2, i);
			ptr = ptr.next;
		}
        
        return result;
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
	// insert from first
		static ListNode insertFirst(int val) {
			ListNode newNode = new ListNode(val);
			newNode.next = head;
			head = newNode;
			return head;
		}
	// insert from last
	static ListNode insertLast(int val) {
		ListNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		ListNode newNode = new ListNode(val);
		temp.next = newNode;
		//newNode.next= null;
		return head;
	}
	static void display() {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("END");
	}
}
