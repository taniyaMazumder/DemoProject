package PracticeForInterview;

public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 static Node head;
 static Node tail; // this is for circular LL
	static class Node {
		int val;
		Node next;
		Node prev;
		public Node(int val, Node next) {
			super();
			this.val = val;
			this.next = next;
		}
		public Node() {
			
		}
		public Node(int val) {
			super();
			this.val = val;
		}
		public Node(int val, Node next, Node prev) {
			super();
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
		
	}
	static Node addFirstSLL(Node head, int val) {
		Node node = new Node(val);
		node.next = head;
		head = node;
		return head;
	}
	static Node addLastSLL(Node head, int val) {
		Node temp = head;
		while(temp.next!= null) {
			temp = temp.next;
		}
		Node node = new Node(val);
		temp.next = node;
		node.next = null;
		return head;
	}
	
	static Node addMiddSLL(int val, int index) {
		Node temp = head; // 5->8->6->13>48->74->null index -3 val=56
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		Node node = new Node(val);
		Node ptr = temp.next;
		temp.next = node;
		node.next = ptr;
		return head;
	}
	static Node deleteFirst() {
		head = head.next;
		return head;
	}
	static Node deleteLast() {
		Node ptr = head;
		Node temp = ptr.next;
		while(temp.next!=null) {
			ptr = temp;
			temp = temp.next;
		}
		ptr.next = null;
		return head;
	}
	static Node deleteMiddleSLL(int index) {
		Node ptr = head;
		Node temp = ptr.next;
		
		for(int i=0; i<index;i++) {
			ptr = temp;
			temp = temp.next;
		}
		ptr.next = ptr.next.next;
		return head;
	}
	static Node addFirstDLL(int val) {
		
		Node node = new Node(val);
		node.next = head;
		node.prev = null;
		if(head!= null) {
			head.prev = node;
		}
		head = node;
		return head;
	}
	static void addLastDLL(int val) {
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		Node node = new Node(val);
		temp.next = node;
		node.prev = temp;
		node.next = null;
	}
	static void addMiddleDLL(int val, int index) {
		Node temp = head;
		
		for(int i=0; i<index;i++) {
			temp = temp.next;
		}
		Node node = new Node(val);
		node.next = temp.next;
		temp.next = node;
		node.prev = temp;
		temp.next.next  =node.next ;
	}
	static void deleteFirstDLL() {
		head = head.next; 
		head.prev = null;
	}
	static void deleteLastDLL() {
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.prev.next = null;
	}
	static void deleteMiddDLL(int index) {
		Node temp = head;
		
		for(int i=0; i<index;i++) {
			temp = temp.next;
		}
		temp.prev.next = temp.next;
	}
	static void addFirstCLL(int val) {
		Node node = new Node(val);
		if(head == null) {
			head = node;
			tail = node;
		}
		tail.next = node;
		tail = node;
		tail.next = head;
		
	}
	static void addLastCLL(int val) {
	  // same as insert first
	}
	static void addMiddleCLL(int val, int index) {
		Node temp = head;
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		Node node = new Node(val);
		node.next = temp.next;
		temp.next = node;
		temp = node;
	}
	static void deleteFirstCLL() {
		head = head.next;
		tail.next = head;
	}
	static void deleteLastCLL() {
		Node temp = head;
		while(temp.next != tail) {
			temp = temp.next;
		}
		temp.next = head;
		tail = temp;
	}
	static void deleteMiddleCLL(int index) {
		Node temp = head;
		Node ptr = temp.next;
		for(int i=0;i<index-1;i++) {
			temp = ptr;
			ptr = ptr.next;
		}
		temp.next = ptr.next;
	}
	static Node insertMidLLRec(int val, int index) {
		Node node = new Node(val);
		return head = helperRec(7,3,node);
	}
	private static Node helperRec(int val, int index, Node node) {
		if(index== 0) {
			Node newNode = new Node(val);
			return newNode;
		}
		node.next =  helperRec(val,index-1,node.next);
		return node;
	}
	// remove dup
	static Node remoDup() {
		Node temp = head;
		
		while(temp.next != null) {
			
			if(temp.val == temp.next.val) {
				temp.next = temp.next.next;
			}else {
				temp = temp.next;
			}
		}
		return head;
	}
	// merge two lists
	static Node merge(Node list1, Node list2) {
		Node dummy = new Node();
		Node dummyHead = dummy;
		
		while(list1!= null && list2!= null) {
			if(list1.val < list2.val) {
				dummyHead.next = list1;
				list1 = list1.next;
				dummyHead = dummyHead.next;
			} else {
				dummyHead.next = list2;
				list2 = list2.next;
				dummyHead = dummyHead.next;
			}
		}
		dummyHead.next= list1!= null ? list1 : list2;
		return dummy.next;
	}
	// cycle detection
	static boolean isCycle(Node head) {
		Node slow= head;
		Node fast = head;
		while(fast!= null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				return true;
			}
		}
		return false;
	}
	// length of cycle
	static int length(Node head) {
		Node slow= head;
		Node fast = head;
		while(fast!= null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				int len =0;
				 Node temp = slow;
				 do {
					 temp = temp.next;
					 len++;
					 
				 }while(temp!= slow);
				return len;
			}
	  }
		return 0;
	}
	static Node findFirstPoint() {
		if(head==null || head.next ==null) {
			return head;
		}
		Node slow= head;
		Node fast = head;
		
		while(fast!= null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				slow = head;
				while(slow!= fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
	    }
		return null;
    }
	// isHappy
	static boolean isHappy(int n) {
		int slow = n;
		int fast =n;
		do {
			slow = findSquare(slow);
			fast = findSquare(findSquare(fast));
		} while(slow!= fast);
		return slow==1 ?true:false ;
	}
	static int findSquare(int num) {
		int sum=0;
		while(num>0) {
			int rem = num %10;
			sum += rem * rem;
			num = num/10;
		}
		return sum;
		
	}
	static Node mid(Node head) {
		Node slow= head;
		Node fast = head;
		
		while(fast!= null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
	    }
		return slow;
	}
	/* 
	 * Merge sort in LL
	 */
	static Node mergeSort(Node head) {
		//1 . find mid
		//2. divide left and right
		// 3. merge both
		Node mid= getMid(head);
		Node left = mergeSort(head);
		Node right = mergeSort(mid);
		
		return merge(left,right);
	}
	private static Node getMid(Node head2) {
		Node slow= head;
		Node fast = head;
		Node temp= head;
		
		while(fast!= null && fast.next != null) {
			temp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
			temp.next = null;
			return slow;
	}
	// bubble sort
	static Node bubbleSort(int row, int col) {
		if(row==0) return head;
		if(row<col) {
			Node f = find(col);
			Node s = find(col+1);
			
			if(f.val >s.val) {
				// swap
				if(f== head) {
					head = s;
					f.next = s.next;
					s.next = f;
				}
				else if(s== tail) {
					Node prev = find(col-1);
					prev.next = f;
					tail =f;
					f.next = null;
					s.next = tail;
				}
				else {
					Node prev = find(col-1);
					prev.next = s;
					f.next = s.next;
					s.next =f;
				}
			}
			bubbleSort(row, col+1);
		} else {
		    bubbleSort(row-1, 0);
		}
		return head;
	}
	private static Node find(int val) {
		Node temp =head;
		if(temp.val == val) {
			return temp;
		}
		temp = temp.next;
		return null;
	}
	// revrse a LL
	static Node reverse(Node head) {
		Node current = head;
		Node prev =null;
		Node next = current.next;
	
		while(current !=null) {
			current.next = prev;
			prev = current;
			current= current.next;
			if(next!= null) {
				next = next.next;
			}
		}
	   return prev;
	}
	// reverse in range
	static Node reverseRange(Node head, int left, int right) {
		if(right ==left) {
			return head;
		}
		Node prev = null;
		Node current = head;
		for(int i=0;current != null && i<left-1;i++) {
			prev = current;
			current= current.next;
		}
		Node first = prev;
		Node newEnd = current;
		Node next = current.next;
		for(int j=0;current != null && j<right-left+1;j++) {
			current.next = prev;
			prev = current;
			current = current.next;
			if(next!= null) {
				next = next.next;
			}
		}
		if(first!= null) {
			first.next = prev;
		}else {
			head = prev;
		}
		newEnd.next = current;
		
		return head;
		
	}
	/*
	 * Palindrome LL-
	 * 
	 */
	static boolean isPalindrome(Node head) {
		 Node middle = mid(head);
		 Node rev = reverse(middle);
		 Node reRevHead = rev;
		 
		 Node hf = head;
		 Node hs = reRevHead;
		
		 
		 while(hf!=null && hs!=null) {
			 if(hf.val == hs.val) {
				 hf = hf.next;
				 hs=hs.next;
				 
			 } else {
			 
			    break;
			 }
		 }
		 reverse(reRevHead);
		return hf == null || hs == null;
	}
	/*
	 * Reorder LL
	 */
	static void reOrder(Node head) {
		Node middle = mid(head);
		Node revHead = reverse(middle);
		
		Node hf = head;
		Node hs = revHead;
		
		while(hf!=null && hs!=null) { // 1->2->3>7>6->5->4->null
			                          // 1->7->2->6->3->5->4=>null
			Node temp = hf.next;      // temp = 2
			hf.next = hs;             // 1->7
			hf = temp;                // hf=2
			
			temp = hs.next;           // temp=6
			hs.next = hf;             // 7->2
			hs = temp;                //  hs =6
		}
		if(hf!=null) {
			hf.next = null;
		}
	}
	/*
	 * reverse in K group
	 */
	static Node reverseKgroup(Node head, int k) {
		if(k==1 || head ==null) {
			return head;
		}
		Node prev = null;
		Node current = head;
		
		int remLen = leng(head);
		while(remLen >=k) {
			Node first = prev;
			Node newEnd = current;
			Node next = current.next;
			for(int i =0; current != null && i<k;i++) {
				current.next = prev;
				prev = current;
				current = current.next;
				if(next!= null) {
					next = next.next;
				}
			}
			if(first!= null) {
				first.next = prev;
			}
			else {
				head = prev;
			}
			newEnd.next = current;
			prev = newEnd;
			
			remLen = remLen -k;
		}
		
		return head;
		
	}
	private static int leng(Node head) {
		Node temp = head;
		int len =1;
		while(temp!=null) {
			temp = temp.next;
			len++;
		}
		return len;
	}
	/*
	 * Reverse Alternate K group
	 */
	static Node reverseAlterKgroup(Node head, int k) {
		if(k==1 || head ==null) {
			return head;
		}
		Node prev = null;
		Node current = head;
		
		while(current!=null) {
			Node first = prev;
			Node newEnd = current;
			Node next = current.next;
			for(int i =0; current != null && i<k;i++) {
				current.next = prev;
				prev = current;
				current = current.next;
				if(next!= null) {
					next = next.next;
				}
			}
			if(first!= null) {
				first.next = prev;
			}
			else {
				head = prev;
			}
			newEnd.next = current;
			for (int j = 0; j < k; j++) {
				prev = current;
				current = current.next;
			}
		}
		return head;
		
	}
	/*
	 * rotations of LL
	 */
	static Node rotationLL(Node head, int k) {
		if(k==1 || head==null) {
			return head;
		}
		int len=1;
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
			len++;
		}
		temp.next = head;
		   // 1>2>3>4>5>6 k=2
				       // 5>6>1>2>3>4>null
		int rotations = k % len; 
		int skip =  len -rotations;
		Node newEnd = head;
		for(int i=0; i<skip-1;i++) {
			newEnd = newEnd.next;
		}
		head = newEnd.next;
		newEnd.next = null;
		return head;
	}
	/*
	 * Rotation from left side
	 */
	static Node rotationLeft(Node head, int k) {
		if(k==1 || head == null) {
			return head;
		}
		int len=1;
		Node current = head;
		while(current.next != null) {
			len++;
			current = current.next;
		}
		k= k%len;
		if(k==0) {
			return head;
		}
			current.next = head; // converted into circular LL
			current = head; // Traverse the LL from head till kth node
			for(int i=1;i<k;i++) {
				current=current.next;
			}
			head = current.next; // now assign k+1 th node as head
			current.next = null;
		
		return head;
	}
}
