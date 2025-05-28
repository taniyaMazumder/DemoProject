package Tree;

import java.util.List;

public class RemoveNodeOutSideRange {

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
	static Node removeNodes(Node node,int min, int max) {
		if(node == null) {
			return null;
		}
		node.left = removeNodes(node.left, min, max);
		node.right = removeNodes(node.right, min, max);
		
		if(node.data < min) {
			Node right = node.right;
			node = null;
			return right;
		}
		if(node.data > max) {
			Node left = node.left;
			node = null;
			return left;
		}
		return node;
		
	}
	static Node insertNode(Node node, int key) {
		if(node == null) {
			Node temp =  new Node(key);
			temp.left = null;
			temp.right = null;
			return temp;
		}
		if(node.data < key) {
			node.left = insertNode(node.left,key);
		}
		if(node.data > key) {
			node.right = insertNode(node.right,key);
		}
		return node;
		
	}
	static void inorder(Node node, List<Integer> list) {
		if(node == null) {
			return;
		}
		inorder(node.left,list);
		list.add(node.data);
		inorder(node.right,list);
	}
}
