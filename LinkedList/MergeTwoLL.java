package LinkedList;

public class MergeTwoLL {

	private static ListNode head;
	private static ListNode tail;
	private static int size;
	
	public static void main(String[] args) {
		MergeTwoLL finalans = new MergeTwoLL();
		finalans.insertLast(1);
		finalans.insertLast(3);
		finalans.insertLast(5);
		MergeTwoLL finalans2 = new MergeTwoLL();
		finalans2.insertLast(1);
		finalans2.insertLast(2);
		finalans2.insertLast(9);
		finalans2.insertLast(14);
		
		MergeTwoLL finalans3 = MergeTwoLL.merge(finalans, finalans2);
		finalans3.display();

		
	}

	public MergeTwoLL() {
		size=0;
	}
	public static MergeTwoLL merge(MergeTwoLL first, MergeTwoLL second) {
		ListNode f = first.head;
		ListNode s = second.head;
		
		MergeTwoLL ans = new MergeTwoLL();
		while(f != null && s != null) {
			if(f.val <= s.val) {
				ans.insertLast(f.val);
				f = f.next;
			} else {
			ans.insertLast(s.val);
			s = s.next;
			}
		}
		while(f != null) {
			ans.insertLast(f.val);
			f = f.next;
		}
		while(s != null) {
			ans.insertLast(s.val);
			s = s.next;
		}
		return ans;
		
		
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
	
	public static ListNode mergeTwoLL(ListNode list1, ListNode list2) {
		ListNode dummyHead = new ListNode();
		ListNode dummyHeadTail = dummyHead;
		
		while(list1 != null && list2 != null) {
			if(list1.val < list2.val) {
				dummyHeadTail.next = list1;
				list1 = list1.next;
				dummyHeadTail = dummyHeadTail.next;
			} else {
				dummyHeadTail.next = list2;
				list2 = list2.next;
				dummyHeadTail = dummyHeadTail.next;
			}
		}
		dummyHeadTail.next = (list1 != null) ? list1 : list2;
		return dummyHead.next;
		
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
