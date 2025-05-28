package Tree;

public class MaxPathSumOfNoSiblingNodes {

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
	static int res =0;
	static int maxPathSum(Node root) {
		if(root == null) {
			return 0;
		}
		solve(root);
		return res;
	}
	private static int solve(Node node) {
		if(node == null) {
			return 0;
		}
		int left = solve(node.left);
		int right = solve(node.right);
		
		if(!isSibling(node,node.left,node.right)) {
			
			int temp = Math.max(Math.max(left, right) + node.data, node.data);
			int ans = Math.max(temp, left + right + node.data);
			
			res = Math.max(ans, res);
			
			return temp;
		} else {
			return -1;
		}
	}
	static boolean isSibling(Node root, Node p, Node q) {
		if(root == null ) {
			return false;
		}
		return root.left==p && root.right == q || root.left==q && root.right == p || isSibling(root.left,p,q) || isSibling(root.right,p,q);
	}
	

}
