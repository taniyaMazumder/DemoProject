 package LinkedList;

public class CycleLength {

	public static void main(String[] args) {
		System.out.println(isHappy(123));

	}
	public boolean hasCycle(ListNode head) {
		if(head == null) {
			return false;
		}
		if(head == head.next) {
			return true;
		}
        ListNode slow= head;
	        ListNode fast = head;
	        
	        while(fast != null && fast.next != null) {
	        	fast = fast.next.next;
	        	slow = slow.next;
                if(fast == slow) {
                    return true;
                }
	        }
            return false;
    }
	
	public static int cycleLength(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		
		while(fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if(fast == slow) {
					// calculate length
					ListNode temp = slow;
					int count =0;
					do {
					temp = temp.next;
					count++;
					}while(temp !=slow);
					return count;
			}
		}
		return 0;
	}
	// Find middle point if cycle exists
	// Find starting point if cycle present
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode entry = head;

        while(fast != null && fast.next != null){
            slow  = slow.next;
            fast = fast.next.next;
            if( slow == fast) {
                while(slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
            return null;
    }
	// Another way to Find starting point if cycle present
	public ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
       
        while(fast != null && fast.next != null){
            slow  = slow.next;
            fast = fast.next.next;
            if( slow == fast) {
            	slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // or return fast cz both are pointing to same node since they collide
            }
        }
            return null;
    }
	
	// Another way to Find starting point if cycle present
	//Step -1 - Find the length of the cycle
	//Step-2 - Move slow ahead by the length of the cycle
	// Step 3- Move slow and fast pointer one by one, it will meet at start 
	public ListNode detectCycle3(ListNode head) {
		int len =0;
		
		ListNode slow= head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
            if(fast == slow) {
            	len =  cycleLength(slow);
            	break;
            }
        }
        // now find the start
        ListNode f = head;
        ListNode s = head;
        
        while(len >0) {
        	s = s.next;
        	len--;
        }
        // Now both will keep moving as forward and they will meet each other
        
        while(f != s) {
        	f = f.next;
        	s = s.next;
        }
        return s;
	}
	public static boolean isHappy(int n) {
		int slow= n;
		int fast= n;
		do {
			slow= countSquareDigit(slow);
			fast = countSquareDigit(countSquareDigit(fast));
			
		}while(slow != fast);
		
		return (slow ==1) ? true : false;
	}
		private static int countSquareDigit(int num) {
			int ans =0;
			while(num >0) {
				int rem = num %10;
				ans = ans + rem * rem;
				num = num/10;
			}
			return ans;
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
