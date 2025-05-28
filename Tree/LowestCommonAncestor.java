package Tree;

import java.util.ArrayList;


public class LowestCommonAncestor {

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
	static TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null || root == node1 || root == node2) {
			return root;
		}
		TreeNode left = LCA(root.left, node1, node2);
		TreeNode right = LCA(root.right,node1,node2);
		
		if(left== null) {
			return right;
		}
		if(right== null) {
			return left;
		}
		else {
			return root; // while we got the node value from both the left & right then return that's node itself.
		}
		
	}
	// Find LCA while node has not given
	TreeNode find(TreeNode root, int x) {
		if(root == null) {
			return null;
		}
		 if(root.value == x) {
			 return root;
		 }
		TreeNode left = find(root.left, x);
		if(left != null) {
			return left;
		}
		return find(root.right, x);
	}
	TreeNode lca(TreeNode root, int n1, int n2) {
	       
		TreeNode xx = find(root,n1);
		TreeNode yy = find(root,n2);
		
	       if(root == null || root== xx || root == yy){
	           return null;
	       }
	       TreeNode left = lca(root.left,n1,n2);
	       TreeNode right = lca(root.right,n1,n2);
	       
	       if(left== null) {
				return right;
			}
			if(right== null) {
				return left;
			}
			else {
				return root; // while we got the node value from both the left & right then return that's node itself.
			}
	    }
	
	// Ancestors of a binary tree where a target has been given and find that target node and return it's upper level ancestors in a list
	
	public static ArrayList<Integer> ancestors(TreeNode root, int target){
		ArrayList<Integer> al = new ArrayList<>();
		helper(root, target ,al);
		return al;
	}
	private static boolean helper(TreeNode root, int target, ArrayList<Integer> al) {
		if(root == null) {
			return false;
		}
		if(root.value == target) {
			return true;
		}
		if(helper(root.left,target,al) || helper(root.right,target,al)) {
			al.add(root.value);
			return true;
		}
		return false;
	}
}
