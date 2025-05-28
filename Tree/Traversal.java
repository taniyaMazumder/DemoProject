package Tree;

public class Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class ListNode {
		private  ListNode root;
		private  ListNode left;
		private ListNode right;
		
	}

	public Traversal() {
		super();
	}

	public static void preOrder(ListNode node) {
		if(node == null) {
			return;
		}
		preOrder(node);
		preOrder(node.left);
		preOrder(node.right);
	}
}
