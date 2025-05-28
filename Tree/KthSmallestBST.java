 package Tree;

import java.util.PriorityQueue;


public class KthSmallestBST {

	int k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	  }
	// apply inorder traversal through Heap- TC- O(n), SC - O(n)
	public static int smallest(TreeNode root, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		inOrder(root, minHeap, k);
		
		int ans=0;
		// remove kth element
		for(int i=0; i <k;i++) {
			ans = minHeap.poll();
		}
		return ans;
	}
	
	public static void inOrder(TreeNode node, PriorityQueue<Integer> minHeap, int k) {
		if(node == null) {
			return;
		}
		inOrder(node.left, minHeap, k);
		
		minHeap.add(node.value);
		
		inOrder(node.right, minHeap, k);
	}
	// without using priorityHeap
	// apply inorder traversal through Heap- TC- O(n), SC - O(n)
	 static int result =0;
		public int kthsmallest(TreeNode root, int k) {
			this.k =k;
			helper(root);
			return result;
		}

		private void helper(TreeNode node) {
			if(node == null) {
				return;
			}
			helper(node.left);
			k--;
			if(k==0) {
				result = node.value;
				return;
			}
			
			helper(node.right);
		}
		//Solution -3 Using Inorder
		static int count =0;
		public static int kthSmallest(TreeNode root, int k) {
			if(root == null) {
				return 0;
			}
			int left = kthSmallest(root.left,k);
			
			if(left != 0) {
				return left;
			}
			count++;
			if(count == k) {
				return root.value;
			}
			return  kthSmallest(root.right,k);
		}
}
