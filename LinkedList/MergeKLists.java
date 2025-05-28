package LinkedList;


public class MergeKLists {
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
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return merge(lists,0,lists.length -1);
    }
    ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        int mid = left +(right - left)/2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid+1, right);

        return mergeTwo(l1,l2);
    }
    ListNode mergeTwo(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(list1!= null && list2!= null) {
            if(list1.val <list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
