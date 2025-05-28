// Given a BT and a key , print the ancestors of the key
package Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAncestorsOfNode {
 
	static Node root;
	public static void main(String[] args) {
		PrintAncestorsOfNode tree = new PrintAncestorsOfNode();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
 
        
        System.out.print(Arrays.asList(tree.Ancestors(tree.root, 7)));

	}
 
	private static class Node {
	    int data;
	    Node left;
	    Node right;

	    public Node(int item) {
	      this.data = item;
	    }
	    
	  }
	
	public static ArrayList<Integer> Ancestors(Node root, int target)
    {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root,target,list);
		return list;
    }
    
	static boolean helper(Node node, int target,ArrayList<Integer> al) 
    {
         /* base cases */
        if (node == null)
            return false;
 
        if (node.data == target)
            return true;
 
        /* If target is present in either left or right subtree 
           of this node, then print this node */
        if (helper(node.left, target,al)
                || helper(node.right, target,al)) 
        {
            al.add(node.data);
            return true;
        }
 
 
        /* Else return false */
        return false;
    }
}
