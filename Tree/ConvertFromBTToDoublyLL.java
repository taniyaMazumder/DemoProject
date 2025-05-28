package Tree;

public class ConvertFromBTToDoublyLL {
	static ListNode head;
	static ListNode tail;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static ListNode convert(TreeNode root) {
		if(root == null) {
			return null;
		}
		inorder(root);
		return head;
	}
	public static void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		
		ListNode newN =  new ListNode(node.value);
		
		if(head == null) {
			head = newN;
			tail = newN;
		} 
		else {
			tail.next = newN;
			newN.prev = tail;
			tail = newN;
	}
		inorder(node.right);
		
	}
	public static class ListNode {
		private int val;
		private ListNode next;
		private ListNode prev;
		
		public ListNode(int val) {
			super();
			this.val = val;
		}
		
		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}

		public ListNode(int val, ListNode next, ListNode prev) {
			super();
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
	}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
      this.value = value;
    }
    
  }

}	
	

