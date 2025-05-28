package Tree;

import java.util.LinkedList;
import java.util.Queue;

import Tree.Traversal.ListNode;

public class FlattenBST {

private static TreeNode root;
	
	public static void main(String[] args) {
		

	}
	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;
	    TreeNode next;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	  }
	// flatten the BST - convert from BST to linked list
			
	// Solution-1
	//T- O(n), space- O(1)
			public static void flatten(TreeNode root) {
		        
		        // pre-order // to get rightmost node and link with the original right nodes to it
				TreeNode current = root;
				while(current != null) {
					if(current.left != null) {
						// to get the right most empty element , keep going right till temp.right = null
						TreeNode temp = current.left;
						while(temp.right !=null) {
							temp = temp.right;
						}
						temp.right = current.right;  // current =1 then temp is 4, then current.right -5,6 added to the 4.right
						current.right = current.left; // current =1, 2-4-5-6 will be added to 1-2-4-5-6
						current.left = null;
					}
					current = current.right; // now current will be 2
				}
		        
		    }
			// Intuition - step1- apply preorder traversal
			// step2: as we traverse store nodes in queue 
			//step3: remove elements from queue and make Linked list 
	// Solution- 2: Time complexity - O(n), space- O(n)

			public static void flatten2(TreeNode root) {
				
				TreeNode current = root;
				Queue<TreeNode> q = new LinkedList<>();
				
				while(current != null ) {
					q.offer(preOrder(current));
				}
				TreeNode currentNode = q.poll();
				TreeNode root2 = new TreeNode(currentNode.value);

				while(!q.isEmpty()) {
					 root2.left = null;
					 root2.right = root2;
				}
								
			}
			
			private static TreeNode preOrder(TreeNode node) {
				if(node == null) {
					return null;
				}
				preOrder(node);
				preOrder(node.left);
				preOrder(node.right);
				return node;
			}
		// Check isValid BST
		
			public boolean isValidBST(TreeNode root) {
				return helper(root, null,null);
			}
		private boolean helper(TreeNode node, Integer low, Integer high) {
			if(node == null) {
				return true;
			}
			if(low != null && node.value <= low) {
				return false;
			}
			if(high != null && node.value >= high) {
				return false;
			}
			boolean left = helper(node.left, low, node.value);
			boolean right = helper(node.right, node.value, high);
			
			return left && right;
		}
		
		// Find Lowest Common Ancestor
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root == p || root == q) {
	        	return root;
	        }
	        TreeNode left = lowestCommonAncestor(root.left, p,q); 
	        TreeNode right = lowestCommonAncestor(root.right, p,q); 
	        if(left != null && right != null) {
	        	return root;
	        }
	      /*  if(left == null) {
	        	return right;
	        }
	        if(right == null) {
	        	return left;
	        }
	        */
	        return left == null ? right : left;
	        
	    }
			
}
