package Tree;

import java.util.HashMap;

public class ConstructBTFromPreToInorder {

	public static TreeNode root;
	
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		root = buildTree(preorder, inorder);
		System.out.println(root);

	}
	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	  }

	  public static TreeNode buildTree(int[] preorder, int[] inorder) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		int[] index = {0};
		return helper(preorder, inorder, map, 0, preorder.length -1, index);
	}

	private static TreeNode helper(int[] preorder, int[] inorder, HashMap<Integer, Integer> map, int left, int right, int[] index) {
		if(left > right) {
			return null;
		}
		int currentNode = preorder[index[0]];
		index[0] ++;
		
		// create a new node after getting the root node's value
		TreeNode node = new TreeNode(currentNode);
		if(left == right)
			return node;
		
		int inorderIndex = map.get(currentNode);
		
		node.left = helper(preorder, inorder, map, left, inorderIndex -1, index);
		node.right = helper(preorder, inorder, map, inorderIndex +1, right, index);
		
		return node;
	}
}
