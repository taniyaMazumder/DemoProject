 package LinkedList;

public class SinglyLL {
	
	private static ListNode head;
	private static ListNode tail;
	private static int size;
	
	public static void main(String[] args) {
		insertFirst(6);
		insertFirst(2);
		insertFirst(1);
		insertFirst(7);
		insertFirst(4);
		insertFirst(3);
		insertFirst(1);
	 
		/* 	insertLast(4);
		insertLast(5);
		insertLast(6);
		insertLast(7);
		
		insertMiddle(100, 3);
		display();
		System.out.println();
		System.out.println(deleteFirst());
		display();
		System.out.println();
		System.out.println(deleteLast2());
		display();
		System.out.println();
		System.out.println(deleteMiddle(2));
		display(); 
		System.out.println();
		insertRec(205,3);
		display(); 
		System.out.println();
		System.out.println(deleteDup(9)); */
		display();
		System.out.println();
	//	recursionWithoutTail(head);
//		insertRec(56,4);
	//	deleteDup(head);
		deleteMiddle(head);
		display();
	}
	

	public SinglyLL() {
		size = 0;
	}
	
	public static void insertFirst(int val) {
		ListNode node = new ListNode(val);
		node.next = head;
		head = node;
				
		if(tail == null) {
			tail = head;
		}
		size += 1;
	}
	
	public static void insertLast(int val) {
		if(tail == null) {
			insertFirst(val);
			return;
		}
		ListNode node = new ListNode(val);
		tail.next = node;
		node.next = null;
		tail = node;
		size += 1;
	}
	
	public static void insertMiddle(int val, int index) {
		if(head == null) {
			insertFirst(val);
			return;
		}
		if(tail == null) {
			insertLast(val);
			return;
		}
		ListNode temp = head;
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}
		ListNode node = new ListNode(val,temp.next);
		temp.next = node;
		size++;
	}
	
	public static int deleteFirst() {
		int val = head.val;
		head = head.next ;
		
		if(head == null) {
			tail = null;
		}
		size--;
		return val;
	}
	
	public static int deleteLast() {
		ListNode temp = head;
		for (int i = 0; i < size -2; i++) {
			temp = temp.next;
		}
		tail = temp;
		temp.next = null;
		size--;
		return temp.val;
	}
	// another way to remove from last
	
	public static ListNode get(int index) {
		ListNode node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	public static int deleteLast2() {
		if(size <=1) {
			return deleteFirst();
		}
		ListNode secondLastnode = get(size -2);
		int val = tail.val;
		tail = secondLastnode;
		secondLastnode.next = null;
		
		return val;
	}
	public static int deleteMiddle(int index) {
		
		if(index ==0) {
			return deleteFirst();
		}
		if(index ==size -1) {
			return deleteLast();
		}
		ListNode prev = get(index -1);
		int value = prev.next.val;
		prev.next = prev.next.next;
		return value;
		
	}
	// remove elements from middle
	
	public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode current = head;
		ListNode dummy = new ListNode(val);
		dummy.next = head;
		ListNode prev = dummy;
		while(current != null) {
			if(current.val == val) {
				prev.next = current.next;
			}
			else {
				prev = current;
			}
			current = current.next;
		}
		return dummy.next;
	}

	
	// remove duplicate
	public static ListNode deleteDup(ListNode head) {
		ListNode temp = head;
		if(temp == null) {
			return temp;
		}
		while(temp != null && temp.next != null) {
			if(temp.val == temp.next.val) {
				temp.next = temp.next.next;
			} else {
			temp = temp.next;
			}
		}
		tail = temp;
		tail.next = null;
		
		return head;
	}
	
	public static ListNode find(int value) {
		ListNode node = head;
		if(node.val == value) {
			return node;
		}
		node = node.next;
		return null;
	}
	
	public static void insertRec(int val, int index) {
		
		head = insertRecLL(val, index, head);
	}
	private static ListNode insertRecLL(int val, int index, ListNode node) {
		// Base Condition
		if(index==0) {
			 ListNode temp = new ListNode(val);
			 size++;
			 return temp;
		}
		node.next= insertRecLL(val, index -1, node.next);
		return node;
	}
	
	// find middle of the LL
	
	public static ListNode midLL() {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	// reverse recursion
	
	public static void recursion(ListNode node) {
		if(node == tail) {
			head= tail;
			return;
		}
		recursion(node.next);
		tail.next = node;
		tail = node;
		tail.next = null;
	}
	
	// reverse recursion without tail
	
		public static void recursionWithoutTail(ListNode node) {
			ListNode temp = head;
			
			while(temp.next != null) {
				temp = temp.next;
			}
			
			if(node == temp) {
				head= temp;
				return;
			}
			recursionWithoutTail(node.next);
			temp.next = node;
			temp = node;
			temp.next = null;
		}
	
	// reverse iteration - in place reverse a LL 
	
	public void recIteration() {
		if(size <=1) {
			return;
		}
	/*	if(head == null) {
            return head;
        } */
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
		head = prev;
	}
	// convert from binary to decimal
	public static int getDecimalValue(ListNode head) {
//		ListNode temp = head;
//        int val=0;
//        while(temp != null) {
//        	val = val + convertDecimal(temp.val);
//            temp = temp.next;
//        	
//        }
//		return val;
//       }
		
	        int res = 0;
	        
	        while(head!=null){
	            res = res<<1 | head.val;   // res = res*2 + head.val;
	            head = head.next;
	        }
	        
	        return res;
	    }
    

	static int convertDecimal(int n) {
	
		int ans =0;
		int base = 2;
		while(n >0) {
			// identify last digit of binary no
			int lastDigit = n & 1;
			n = n >> 1;
			ans += lastDigit * base;
			base = base *2;
		}
		return ans;
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
public static ListNode deleteMiddle(ListNode head) {
        
        ListNode middle = mid(head);
        ListNode current = head;
        ListNode prev =null;
        while(current != null) {
            if(current != middle) {
                prev = current;
                current = current.next;
            } 
            else {
                if(current.next!= null) {
                    prev.next = current.next;
                }
                break;
            }
        }
          return head;
    }
    public static ListNode mid(ListNode head) {
	        ListNode fast = head;
	        ListNode slow = head;

	        while(fast != null && fast.next != null) {
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        return slow;
	    }
	
	
}
