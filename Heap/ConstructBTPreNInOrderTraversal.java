package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ConstructBTPreNInOrderTraversal {

	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		System.out.println(Arrays.toString(preorder) + Arrays.toString(inorder));
		System.out.println(buildBinaryTree(preorder, inorder));
		
	/*	ConstructBTPreNInOrderTraversal obj= new ConstructBTPreNInOrderTraversal();
		//obj.buildBinaryTree(preorder, inorder);
		obj.prettyDisplay();
		System.out.println(buildBinaryTree(preorder, inorder)); */
	}

	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	  }

	  private static TreeNode root;

	  // insert elements
	  public void populate(Scanner scanner) {
	    System.out.println("Enter the root Node: ");
	    int value = scanner.nextInt();
	    root = new TreeNode(value);
	    populate(scanner, root);
	  }

	  private void populate(Scanner scanner, TreeNode node) {
	    System.out.println("Do you want to enter left of " + node.value);
	    boolean left = scanner.nextBoolean();
	    if (left) {
	      System.out.println("Enter the value of the left of " + node.value);
	      int value = scanner.nextInt();
	      node.left = new TreeNode(value);
	      populate(scanner, node.left);
	    }

	    System.out.println("Do you want to enter right of " + node.value);
	    boolean right = scanner.nextBoolean();
	    if (right) {
	      System.out.println("Enter the value of the right of " + node.value);
	      int value = scanner.nextInt();
	      node.right = new TreeNode(value);
	      populate(scanner, node.right);
	    }

	  }
	  public void prettyDisplay() {
		    prettyDisplay(root, 0);
		  }

		  private void prettyDisplay(TreeNode node, int level) {
		    if (node == null) {
		      return;
		    }

		    prettyDisplay(node.right, level + 1);

		    if (level != 0) {
		      for (int i = 0; i < level - 1; i++) {
		        System.out.print("|\t\t");
		      }
		      System.out.println("|------->" + node.value);
		    } else {
		      System.out.println(node.value);
		    }
		    prettyDisplay(node.left, level + 1);
		  }
	public static TreeNode buildBinaryTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i < inorder.length;i++) {
			map.put(inorder[i], i);
		}
		int[] index = {0};
		return helper(preorder, inorder, map,0, preorder.length -1, index);
	}

	private static TreeNode helper(int[] preorder, int[] inorder, HashMap<Integer, Integer> map, int left , int right, int[] index) {
		if(left > right) {
			return null;
		}
		int current = preorder[index[0]];
		index[0]++;
		
		// create a new node after getting the root node's value
		TreeNode node = new TreeNode(current);
		if(left == right) { // while we are in leaf node
			return node;
		}
		
		// Now need to find the index from inorder and put in map
		int inorderIndex = map.get(current);
		
		node.left  = helper(preorder, inorder, map, left, inorderIndex -1, index);
		node.right  = helper(preorder, inorder, map, inorderIndex +1, right, index);
		
		return node;
		
	}
	
}
