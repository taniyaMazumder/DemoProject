// 4 rules of AVL:
// Case-1- while it's left-left case- it will be right rotate
// case-2: while it's left-right case - it will be left rotate on C -> right rotate on P
// Case-3: while right-right case- it will be left rotate on P 
// Case-4: while right-left case- it will be right rotate on C-> left rotate on P

package Tree;

public class AVLTree {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		for(int i=0; i <1000; i++) {
			tree.insert(i);
		}
		System.out.println(tree.height());
	}
	AVLTree(){
		
	}
	static TreeNode root;
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		int height;
		TreeNode(){
			
		}
		public TreeNode(int val, TreeNode left, TreeNode right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public int height() {
	    return height(root);
	  }
	  private int height(TreeNode node) {
	    if (node == null) {
	      return -1;
	    }
	    return node.height;
	  }
	public void insert(int val) {
		root =  insert(root,val);
	}
	public TreeNode insert(TreeNode node,int val) {
		if(node == null) {
			 node = new TreeNode(val);
			return node;
		}
		if( val < node.val) {
			node.left = insert(node.left, val);
		}
		else if(val > node.val) {
			node.right = insert(node.right,val);
		}
		node.height = Math.max(height(node.left), height(node.right)) +1;
		return rotate(node);
	}
	private TreeNode rotate(TreeNode node) {
		
		if(height(node.left) - height(node.right) >1) {
		//  left heavy
			if(height(node.left.left) - height(node.left.right) >0) {
				// left left rotate
				return rightRotate(node);
			}
			if(height(node.left.left) - height(node.left.right) <0) {
				// left right rotate
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		}
		// right heavy
		if(height(node.left) - height(node.right) <-1) {
			if(height(node.right.left) - height(node.right.right) <0) {
				// right -right 
				return leftRotate(node);
			}
			if(height(node.right.left) - height(node.right.right) >0) {
				// right -left 
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}
		
		return node;
	}
	private TreeNode rightRotate(TreeNode p) {
		TreeNode c= p.left;
		TreeNode t = c.right;
		
		c.right = p;
		p.left =t;
		
		p.height = Math.max(height(p.left), height(p.right)) +1;
		c.height = Math.max(height(c.left), height(c.right)) +1;
		
		return c;
	}
	private TreeNode leftRotate(TreeNode c) {
		TreeNode p = c.right;
		TreeNode t = p.left;
		
		p.left = c;
		c.right =t;
		
		p.height = Math.max(height(p.left), height(p.right)) +1;
		c.height = Math.max(height(c.left), height(c.right)) +1;
		
		return p;
	}
}
