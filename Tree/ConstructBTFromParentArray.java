// construct binary tree from a given parent array
package Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBTFromParentArray {

	public static void main(String[] args) {
		List<Integer> parent = Arrays.asList(-1, 0, 0, 1, 1, 3, 5); 
		root = constructBT(parent);
		System.out.println("Inorder traversal of binary tree");
		inorder(root);
	}
   private static void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}
   static TreeNode root;
	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	  }
	
	static TreeNode constructBT(List<Integer> parent) {
		Map<Integer, TreeNode> map = new HashMap<>();
		int n = parent.size();
		
		for(int i =0; i<n;++i) {
		if(parent.get(i) == -1) {
			TreeNode root = new TreeNode(i);
			map.put(i, root);
		}
		else {
		TreeNode parentNode = map.get(parent.get(i));
		if(parentNode == null) {
			parentNode = new TreeNode(parent.get(i));
			map.put(parent.get(i), parentNode);
		}
		
			TreeNode currentNode = new TreeNode(i);
			if(parentNode.left == null) {
				parentNode.left = currentNode;
			}
			if(parentNode.right == null) {
				parentNode.right = currentNode;
			}
			map.put(i, currentNode);
		}
	}
		return root;
	}
}
