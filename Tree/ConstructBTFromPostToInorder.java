package Tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class ConstructBTFromPostToInorder {

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

	  public static TreeNode buildTree(int[] preorder, int[] inorder) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		int[] index = {0};
		return helper(preorder, inorder, map, 0, preorder.length -1, index);
	}

	private static TreeNode helper(int[] preorder, int[] inorder, HashMap<Integer, Integer> map, int left, int right, int[] index) {
		if(left > right) {
			return null;
		}
		//Collections.reverse(Arrays.asList(preorder)); 
		//Loop through the array in reverse order  
		int[] newArray = new int[preorder.length];
        for (int i = preorder.length-1; i >= 0; i--) {  
        	newArray[i] = preorder[i];
          }
        
		int currentNode = newArray[index[0]];
		index[0] ++;
		
		// create a new node after getting the root node's value
		TreeNode node = new TreeNode(currentNode);
		if(left == right)
			return node;
		
		int inorderIndex = map.get(currentNode);
		
		node.left = helper(preorder, inorder, map, left, inorderIndex -1, index);
		node.right = helper(preorder, inorder, map, inorderIndex +1, right, index);
		
		return node;
   }
}
