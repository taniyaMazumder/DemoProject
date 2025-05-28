package Tree;

public class ConstructBTFromPreOrder {

	static TreeNode root;
	public static void main(String[] args) {
		int[] preorder = {10, 5, 1, 7, 40, 50};
       for(int i=0; i< preorder.length;i++) {
    	   createNode(preorder[i]);
       }
       inorder(root);
	}

	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	  }
	static TreeNode buildTree(TreeNode node, int val) {
		if(node == null) {
			node = new TreeNode(val);
			return node;
		}
		if(node.value > val) {
			node.left = buildTree(node.left,val);
		}
		if(node.value < val) {
			node.right = buildTree(node.right,val);
		}
		return node;
	}
	static void createNode(int data) {
		root = buildTree(root,data);
	}
	static void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		System.out.println(node.value +" ");
		inorder(node.right);
	}
}
