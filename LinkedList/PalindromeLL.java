package LinkedList;

public class PalindromeLL {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	
	    public boolean isPalindrome(ListNode head) {
	        ListNode mid= mid(head);
	        ListNode revHead= reverse(mid);
	        ListNode rereverse = revHead;
	        
	        while(head !=null && revHead!=null) {
	            if (head.val == revHead.val) {
	            head = head.next;
	            revHead = revHead.next;
	            } 
	            else {
	                break;
	            }
	       }
	        reverse(rereverse);

	    return head ==null || revHead ==null;
	        
	    }
	    public ListNode mid(ListNode head) {
	        ListNode fast = head;
	        ListNode slow = head;

	        while(fast != null && fast.next != null) {
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        return slow;
	    }
	    public ListNode reverse(ListNode head) {
	        ListNode prev= null;
	        ListNode present = head;
	        ListNode next = present.next;

	        while(present != null) {
	            present.next = prev;
	            prev= present;
	            present = next;
	            if(next != null) {
	                next = next.next;
	            }
	        }
	        return prev;
	    }
	    
	    private static class ListNode {
			private int val;
			private ListNode next;
			
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

