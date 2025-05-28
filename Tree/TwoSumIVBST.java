 package Tree;

import java.util.HashSet;

public class TwoSumIVBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	  }
	public static boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> set = new HashSet<>();
		return helper(root,k,set);
	}
	private static boolean helper(TreeNode node, int k, HashSet<Integer> set) {
		if(node == null) {
			return false;
		}
		if(set.contains( k- node.value)) {
			return true;
		}
		set.add(node.value);
		return helper(node.left, k , set) || helper(node.right, k , set);
	}
}
