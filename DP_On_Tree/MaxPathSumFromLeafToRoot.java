package DP_On_Tree;

public class MaxPathSumFromLeafToRoot {

	public static int res = Integer.MIN_VALUE;
	public static int maxSum = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Node {
	    int data;
	    Node left;
	    Node right;

	    public Node(int item) {
	      this.data = item;
	    }
	    
	  }
	 public static int maxPathSum(Node root)
	    {
	        if(root == null) {
	            return 0;
	        }
	        maxSum =Integer.MIN_VALUE;
	        helper(root,0);
			return maxSum ;
		}
		static void helper(Node node, int currSum) {
			if(node == null) {
				return;
			}
			currSum = currSum + node.data;
			
			if(node.left == null && node.right == null) {
				maxSum = Math.max(maxSum,currSum);
			}
			helper(node.left,currSum);
			helper(node.right,currSum);
			
		}	
		//Max Path Sum 2 Special Nodes
		/*
		 * Calculate the maximum sum from leaf to root in the left subtree of x (Find the maximum sum leaf to root path in a Binary Tree).
		 *  Find the maximum sum from leaf to root in the right subtree of x. Add the above two calculated values and 
		 *  x->data compare the sum with the maximum value obtained so far and update the maximum value. Return the overall maximum value. 
		 *  The time complexity of the above solution is O(n2).
		 */
//		static int maxPathSum2(Node root) {
//			int left = helper(root.left,0);
//			
//		}
}
