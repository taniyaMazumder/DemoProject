 package DP_On_Tree;

public class DiameterOfTree {

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
	public static int diameter(TreeNode root) {
		solve(root);
		return res -1;
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
		int temp = Math.max(left, right) + 1;
		int ans = Math.max(temp, 1 + left + right);
		
		res = Math.max(ans, res);
		
		return temp;
	}

}
