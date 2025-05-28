package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructBTPostNInorderTraversal {

	static TreeNode root;
	public static void main(String[] args) {
		
		int[] postorder = {9,15,7,20,3};
		int[] inorder = {9,3,15,20,7};
		root = buildBinaryTree(postorder, inorder);
		System.out.println(root);
	}

	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	  }
	
	public static TreeNode buildBinaryTree(int[] postorder, int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i < inorder.length;i++) {
			map.put(inorder[i], i);
		}
		
		return helper(postorder, inorder, map, 0,inorder.length -1, 0,postorder.length -1);
	}

	private static TreeNode helper(int[] postorder, int[] inorder, HashMap<Integer, Integer> map, int leftIn, int rightIn, int leftPost, int rightPost) {
		if(leftIn > rightIn || leftPost > rightPost) {
			return null;
		}
		
		int current = postorder[rightPost];
		// create a new node for building tree
		
		TreeNode node = new TreeNode(current);
				
		int inorderIndex = map.get(current);
		
		int leftSize = inorderIndex - leftIn;
		
		node.left = helper(postorder, inorder, map, leftIn, inorderIndex -1, leftPost , leftPost + leftSize -1);
		node.right = helper(postorder, inorder, map, leftIn + leftSize +1, rightIn, leftPost + leftSize , rightPost -1);
		
		return node;
	}

		// Note: // Now convert from array to list 
	//	List<Integer> postList = Arrays.stream(postorder).boxed().collect(Collectors.toList());
	//	Collections.reverse(postList);
		// Now convert again from list to array
	//	postorder = postList.stream().mapToInt(Integer :: intValue).toArray();
}
