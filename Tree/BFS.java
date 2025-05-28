package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;
	    TreeNode next;
	    int index;
	    TreeNode node;
	    
	    public TreeNode(int value) {
	      this.value = value;
	    }
	    public TreeNode(TreeNode node, int index) {
	    	this.node = node;
            this.index = index;
		   }
	  }
	public static List<List<Integer>> bfs(TreeNode root){
		List<List<Integer>> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>(levelSize);
			
			for (int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				currentLevel.add(currentNode.value);
				
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			list.add(currentLevel);
		}
		
		return list;
	}
	
	// Average of level
	public static List<Double> avgOfLevels(TreeNode root){
		List<Double> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			
			double avgLevel =0;
			for(int i=0; i< levelSize;i++){ // for loop has been used to keep track avg of each level
				TreeNode currentNode = queue.poll();
				
				avgLevel = avgLevel + currentNode.value;
				
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			avgLevel = avgLevel / levelSize;
			list.add(avgLevel);
		}
			return list;
		}
	// find max value of each level 
	class Solution {
	    static TreeNode root;
	    ArrayList<Integer> maximumValue(TreeNode root) {
	    ArrayList<Integer> res = new ArrayList<>();
	        if (root == null)
	            return res;

	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);

	        while (!q.isEmpty()) {
	            int n = q.size();
	            int maxVal = Integer.MIN_VALUE;

	            for (int i = 0; i < n; i++) {
	            	TreeNode node = q.poll();
	                maxVal = Math.max(maxVal, node.value);

	                if (node.left != null)
	                    q.add(node.left);
	                if (node.right != null)
	                    q.add(node.right);
	            }

	            res.add(maxVal);
	        }

	        return res;

	    }
	}
	// Level order successor
	public static TreeNode successor(TreeNode root , int key) {
		if(root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			 
			 TreeNode currentNode = queue.poll();
			 
				 if(currentNode.left != null) {
				 	 queue.offer(currentNode.left);
				 }
				 if(currentNode.right != null) {
					 queue.offer(currentNode.right);
				 } 
				 if(currentNode.value == key) { 
					 break ;
				 }
			 
		}
		return queue.peek();
	}
	
	
	// Connect Next right pointers
	public static TreeNode connect(TreeNode root) {
		if(root == null) {
			return null;
		}
		TreeNode leftMost = root;
		while(leftMost != null) {
			TreeNode current = leftMost;
			while(current != null) {
				current.left.next = current.right;
				if(current.next != null) {
					current.right.next = current.next.left;
				}
				current = current.next;
			}
			leftMost = leftMost.left;
		}
			
		return root;
		
	}
	// Kth largest element of a binary tree
	public int kthLargest(TreeNode root, int k) {
        // Your code here
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        Collections.reverse(list);
        for(int i=0;i<list.size() ;i++){
            if(i == k-1){
                return list.get(i);
            }
        }
        return -1;
    }
    void inorder(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
        inorder(node.left,res);
        res.add(node.value);
        inorder(node.right,res);
    } 
	
	// Find Maximum width
	public static int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
        	return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.left);
        
        while(!queue.isEmpty()) {
        	TreeNode currentNode = queue.poll();
        	queue.offer(currentNode.left);
        	queue.offer(currentNode.right);
        	if(currentNode.left == null && currentNode.right == null) {
        		break;
        	}
        }
        return queue.size();
    }
	// using indexes
	public static int widthOfBinaryTreeUsingIndex(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(new TreeNode(root,0));
		int max =0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			int start =0, end =0;
			for(int i= 0 ; i < size; i++) {
				TreeNode currentNode = queue.poll();
				int idex =currentNode.index;
				
				if(i ==0) {
					start = idex ;
				}
				if(end == size -1) {
					end = idex;
				}
				if(currentNode.node.left != null) {
					queue.add(new TreeNode(currentNode.node.left, 2 * idex +1));
				}
				if(currentNode.node.right != null) {
					queue.add(new TreeNode(currentNode.node.right, 2 * idex +2));
				}
			}
			max = Math.max(max, end - start +1);
		}
		return max; 
	}

	// Function to check whether all nodes of a tree have the value equal to the sum of their child nodes.
	public static int isSumProperty(TreeNode node) {
		if(node == null || node.left == null && node.right == null) {
			return 1;
		}
		int left_data =0;
		int right_data = 0;
		
		if(node.left != null) {
			left_data = node.left.value;
		}
		if(node.right != null) {
			right_data = node.right.value;
		}
		if((node.value == left_data + right_data) && (isSumProperty(node.left) != 0) && (isSumProperty(node.right)!= 0)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	// find-count-of-singly-subtrees
	// A Single Valued Subtree is one in which all the nodes have same value. Expected time complexity is O(n)
	
	public boolean countSingleRec(TreeNode root, int count) {
		if(root == null) {
			return true;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			TreeNode current = q.poll();
			if(isSingly(current)) {
				count++;
			}
			if(current.left!= null) {
				q.offer(current.left);
			}
			if(current.right!= null) {
				q.offer(current.right);
			}
		}
		return true;
	}

	private boolean isSingly(TreeNode node) {
		if(node == null) {
			return false;
		}
		if(node.left!= null && node.value != node.left.value || node.right!= null && node.value != node.right.value) {
			return false;
		}
		return true;
	}
}
