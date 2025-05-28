package Tree;

public class CheckSumTree {

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
	boolean isSumTree(Node root)
	{
		if(root == null || root.left == null && root.right == null) {
			return true;
		}
		int left = findSum(root.left);
		int right = findSum(root.right);
             if((root.data == left + right) && (isSumTree(root.left)) && (isSumTree(root.right))) {
            	 return true;
             }
             else {
            	 return false;
             }
	}
	int findSum(Node node) {
		if(node == null) {
			return 0;
		}
		return findSum(node.left) + node.data + findSum(node.right);
	}
}
