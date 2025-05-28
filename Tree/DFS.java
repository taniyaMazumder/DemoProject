package Tree;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	private static TreeNode root;
	
	public static void main(String[] args) {
		DFS dfs = new DFS();
		dfs.invertBinaryTree(root);

		 int[] parent = {-1,0,0,1,1,2};
	     String s = "abacbe";
	     System.out.println(longestPath(parent,s));
	}
	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	  }
	
	int diameter = 0;
	  public int diameterOfBinaryTree(TreeNode root) {
	    height(root);
	    return diameter-1;
	  }
	  int height(TreeNode node) {
	    if(node == null) {
	      return 0;
	    }

	    int leftHeight = height(node.left);
	    int rightHeight = height(node.right);

	    int dia = leftHeight + rightHeight + 1;
	    diameter = Math.max(diameter, dia);

	    return Math.max(leftHeight, rightHeight) + 1;
	    
	  }
	 public TreeNode invertBinaryTree(TreeNode root) {
		 // base condition
		 if(root == null) {
		      return null;
		   }
		 // hypothesis-//LEFT AND RIGHT TRAVERSAL
		 TreeNode left = invertBinaryTree(root.left);
		 TreeNode right = invertBinaryTree(root.right);
		 // Induction
		 root.left = right;
		 root.right = left;
		 
		 return root;
		 
	 }
	 public int maxDepth(TreeNode root) {
		 return heightMax(root);
	 }
	 public int heightMax(TreeNode root) {
		 int left = heightMax(root.left);
		 int right = heightMax(root.right);
		 
		return Math.max(left, right) +1;
		 
	 }
	 // convert from sorted array to BST
	 public TreeNode sortedArrayToBST(int[] nums) {
			return sorted(nums,0, nums.length );
		}
		private TreeNode sorted(int[] nums, int start, int end) {
			if(start >= end) {
				return null; 
			}
			int mid = start + (end - start)/2;
			TreeNode root = new TreeNode(nums[mid]);
			root.left = sorted(nums, start, mid);
			root.right = sorted(nums, mid+1, end);
			return root;
			
		}
//		Longest Path With Different Adjacent Characters
				static int path =1;
				public static int longestPath(int[] parent, String s) {
			        
					List<List<Integer>> adj = new ArrayList<>();
					for(int j=0; j< parent.length;j++) {
						adj.add(new ArrayList<>());
					}
					for(int i=1; i < parent.length;i++) {
						adj.get(parent[i]).add(i);
					}
					dfsPathCount(adj,0,s);
			        return path;
			    }
				public static int dfsPathCount(List<List<Integer>> adjacentNodes, int currentNodes, String str) {
					
					int currentMaxCount=0;
					int secondMaxCount=0;
					
					for(int nextNodes : adjacentNodes.get(currentNodes)) {
						
						int result = dfsPathCount(adjacentNodes , nextNodes, str);
						if(str.charAt(currentNodes) == str.charAt(nextNodes)) {
							continue;
						}
						if(result > currentMaxCount) {
							secondMaxCount = currentMaxCount;
							currentMaxCount = result;
						}
						else if(result > secondMaxCount) {
							secondMaxCount = result;
						}
					}
					path = Math.max(path, currentMaxCount + secondMaxCount +1) ;
					
					return 1+ currentMaxCount;
				}
}
