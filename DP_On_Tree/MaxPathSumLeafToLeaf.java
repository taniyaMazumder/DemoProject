// Max path sum from leaf to leaf node only

package DP_On_Tree;

public class MaxPathSumLeafToLeaf {

	public static int res = Integer.MIN_VALUE;
	
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
	public static int maxPathSum(TreeNode root) {
		solve(root);
		return res ;
	}
	private static int solve(TreeNode root) {
		// base condition
		if(root == null) {
			return 0;
		}
		// hypothesis-//LEFT AND RIGHT TRAVERSAL
		int left = solve(root.left);
		int right = solve(root.right);
		
		//INDUCTION
		int temp = Math.max(left, right) + root.val;
		/*
		 * not neccessarily code 
		 * it will return the value of node itsef while the node is leaf only
		 * if(root.left == null && root.right == null) {
		 * 		return temp = Math.max(temp, root.val);
		 */
		int ans = Math.max(temp, left + right + root.val);
		
		res = Math.max(ans, res);
		
		return temp;
	}
	
}
