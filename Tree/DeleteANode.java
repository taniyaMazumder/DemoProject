package Tree;

public class DeleteANode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int val) {
	      this.val = val;
	    }
	  }
	static TreeNode deleteANode(TreeNode root, int key) {
		if(root == null) {
			return root;
		}
		if(root.val == key) {
			return helper(root);
		}
		TreeNode dummy =root;
		while(root!= null) {
			if(root.val > key) {
				if(root.left!= null && root.left.val ==key) {
					root.left = helper(root.left);
				} else {
					root = root.left;
				}
			}else {
				if(root.right!= null && root.right.val ==key) {
					root.right = helper(root.right);
				} else {
					root = root.right;
				}
			}
		}
		return dummy;
	}
	private static TreeNode helper(TreeNode root) {
		if(root.left == null) {
			return root.right;
		}
		else if(root.right == null) {
			return root.left;
		}
		TreeNode rightChild = root.right;
		TreeNode lastRightChild = findLastRight(root.left);
		lastRightChild.right = rightChild;
		return root.left;
	}
	private static TreeNode findLastRight(TreeNode root) {
		if(root == null) {
			return root;
		}
		return findLastRight(root.right);
	}
}
