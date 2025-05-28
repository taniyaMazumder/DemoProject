// Max path sum from any node to any node- root to leaf/ non-leaf to leaf/ leaf to leaf

package DP_On_Tree;


public class MaxPathSumAnyNode {
	
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
		int temp = Math.max(Math.max(left, right) + root.val, root.val);
		int ans = Math.max(temp, left + right + root.val);
		
		res = Math.max(ans, res);
		
		return temp;
	}
}
