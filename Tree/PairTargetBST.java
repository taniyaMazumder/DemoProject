// Two sum IV is same as Pair Present equal to target

package Tree;

import java.util.HashSet;

public class PairTargetBST {

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
	static int count =0;
	public int isPairPresent(Node root, int target)
    {
		HashSet<Integer> set = new HashSet<>();
        helper(root,set, target);
		return count;
        
    }
	boolean helper(Node node, HashSet<Integer> set, int sum) {
		if(node == null) {
			return false;
		}
		if(set.contains(sum - node.data)) {
			count++;
			return true;
		}
		set.add(node.data);
		
		return helper(node.left,set,sum) || helper(node.right,set,sum);
	}
}
