package Tree;

public class SwappedTwoNodesBT {

	static TreeNode first;
	static TreeNode second;
	static TreeNode prev;
	
	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	  }

	 private static TreeNode root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void helper(TreeNode node) {
		inorder(node);
		int temp = first.value;
		first.value = second.value;
		second.value = temp;
	}

	private static void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		
		if(prev != null && prev.value > node.value) {
			if(first == null) {
				first = prev;
			}
			second = node;
		}
		prev = node;
		inorder(node.right);
		
	}
}
