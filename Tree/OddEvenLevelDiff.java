package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class OddEvenLevelDiff {

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
	
	int levelOrderTraversalBSF(Node root) {
		if(root == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int level =0;
		int diff =0;
		int oddsum = 0;
		int evensum = 0;
		
		while(!queue.isEmpty()) {
			int size =queue.size();
			level ++;
			
			for(int i=0; i<size;i++) {
				Node currentNode = queue.poll();
				
				if(level % 2 == 0) {
					evensum += currentNode.data;
				}
				if(level % 2 != 0) {
					oddsum += currentNode.data;
				}
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
					
				}
			}
			diff = oddsum - evensum;
		}
		return diff;
	}
}
