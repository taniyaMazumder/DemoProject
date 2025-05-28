package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class AvgLevelBFS {

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
	public static List<Double> bfs(TreeNode root){
		List<Double> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			double avgLevel =0.0;
			for (int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				avgLevel += currentNode.value ;
						
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			avgLevel = avgLevel /levelSize;
			
			list.add(avgLevel);
		}
		
		return list;
	}
	
	// find successsor
	public TreeNode findSuccessor(TreeNode root, int key) {
		if(root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			if(currentNode.left != null) {
				queue.offer(currentNode.left);
			}
			if(currentNode.right != null) {
				queue.offer(currentNode.right);
			}
			if(root.value == key) {
				break;
			} 
		}
		return queue.peek();
	}
	
	// zigzag order traversal
	public List<List<Integer>> zigzag(TreeNode root){
		
		List<List<Integer>> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		Deque<TreeNode> dequeue = new LinkedList<>();
		
		dequeue.addFirst(root);
		boolean reverse = false;
		while(!dequeue.isEmpty()) {
			int levelSize = dequeue.size();
		      List<Integer> currentLevel = new ArrayList<>(levelSize);
		      for (int i=0; i < levelSize; i++) {
				
				if(!reverse) {
					TreeNode currentNode = dequeue.pollFirst();
			          currentLevel.add(currentNode.value);
					if(currentNode.left != null) {
						dequeue.addLast(currentNode.left);
					}
					if(currentNode.right != null) {
						dequeue.addLast(currentNode.right);
					}
				} else {
					TreeNode currentNode = dequeue.pollLast();
			          currentLevel.add(currentNode.value);
					if(currentNode.right != null) {
						dequeue.addFirst(currentNode.right);
					}
					if(currentNode.left != null) {
						dequeue.addFirst(currentNode.left);
					}
				}
		      }
			reverse = !reverse;	
			list.add(currentLevel);
		}
		return list;
	}
	
	// Right side view
	public List<Integer> rightSideView(TreeNode root) {
	    List<Integer> result = new ArrayList<>();

	    if (root == null) {
	      return result;
	    }

	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);

	    while (!queue.isEmpty()) {
	      int levelSize = queue.size();

	      for (int i=0; i < levelSize; i++) {
	        TreeNode currentNode = queue.poll();

	        if (i == levelSize - 1) {
	          result.add(currentNode.value);
	        }
	        
	        if (currentNode.left != null) {
	          queue.offer(currentNode.left);
	        }
	        if (currentNode.right != null) {
	          queue.offer(currentNode.right);
	        }
	      }
	    }
	    return result;
	  }
	
	public boolean isSymmetric(TreeNode root) {
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);

	    while (!queue.isEmpty()) {
	        TreeNode left = queue.poll();
	        TreeNode right = queue.poll();
	        
	        if(left == null && right == null) {
	        	continue;
	        }
	        if(left == null || right == null) {
	        	return false;
	        }
	        if(left.value != right.value) {
	        	return false;
	        }
	       queue.offer(left.left);
	       queue.offer(right.right);
	       queue.offer(left.right);
	       queue.offer(right.left);
	    }
	    return true;
	}
	
	/*
	 * -----------------------------------------------------------------------------------------------------
	 * Another way of checking issymetric
	 */
	
	public boolean isSymmetric2(TreeNode root) {
		if(root.left == null && root.right == null) {
			return root.left == root.right;
		}
		TreeNode p = root.left;
		TreeNode q = root.right;
		
		return helper(p,q);
	}
	private boolean helper(TreeNode p, TreeNode q) {
		if(p == null && q == null) {
			return true;
		}
		if(p == null || q == null) {
			return false;
		}
		return (p==q) && (helper(p.left , q.right)) && (helper(p.right , q.left));
	}

	// Intuition- step 1- find the node, step2- find the level of those nodes, step 3- check whether they are siblings or not
	public boolean isCousin(TreeNode root, int x, int y) {
		TreeNode xx = findNode(root,x);
		TreeNode yy = findNode(root,y);
		
		return (level(root, xx,0 ) == level(root, yy,0 )) && (!isSibling(root,xx, yy));
	}

	private boolean isSibling(TreeNode root, TreeNode x, TreeNode y) {
		if(root == null) {
			return false;
		}
		return (root.left ==x && root.right == y) || (root.left ==y && root.right == x) 
				|| isSibling(root.left,x,y) || isSibling(root.right, x,y);
	}

	private int level(TreeNode root, TreeNode x, int level) {
		if(root == null) {
			return 0;
		}
		if(root == x) {
			return level;
		}
		int lev= level(root.left, x,level+1);
		if(lev != 0) {
			return lev;
		}
		return level(root.right, x,level+1);
	}

	private TreeNode findNode(TreeNode root, int x) {
		if(root == null) {
			return null;
		}
		if(root.value == x) {
			return root;
		}
		TreeNode left = findNode(root.left, x);
		if(left != null) {
			return left;
		}
		return findNode(root.right, x);
	}
}
