package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class practiceAvgLevel {
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
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			int levelSize = q.size();
			double sum =0;
			TreeNode currentNode = q.poll();
			sum += currentNode.value;
			if(currentNode.left != null) {
				q.offer(currentNode.left); 
			}
			if(currentNode.right != null) {
				q.offer(currentNode.right); 
			}
			
			sum = sum/levelSize;
			list.add(sum);
		}
		return list;
	}
	public static TreeNode levelOrderSuccessor(TreeNode root, int key){
		if(root == null) {
			return null;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
						
			TreeNode currentNode = q.poll();
			if(currentNode.left != null) {
				q.offer(currentNode.left);
			}
			if(currentNode.right != null) {
				q.offer(currentNode.right);
			}
			if(currentNode.value == key) {
				break;
			}
		}
		return q.peek();
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
		List<List<Integer>> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		Deque<TreeNode> deq = new LinkedList<>();
		boolean rev =  false;
		deq.addFirst(root);
		while(!deq.isEmpty()) {
			int levelSize = deq.size();
		      List<Integer> currentLevel = new ArrayList<>(levelSize);
		      for (int i=0; i < levelSize; i++) {
		    	  if(!rev) {
		    		  // normal order - remove front - add in back
		    		  TreeNode currentNode = deq.pollFirst();
		    		  currentLevel.add(currentNode.value);
						if(currentNode.left != null) {
							deq.addLast(currentNode.left);
						}
						if(currentNode.right != null) {
							deq.addLast(currentNode.right);
						}
						
					} else { // rev order-- remove back - add in front
						TreeNode currentNode = deq.pollLast();
						currentLevel.add(currentNode.value);
						if(currentNode.right != null) {
							deq.addFirst(currentNode.right);
						}
						if(currentNode.left != null) {
							deq.addFirst(currentNode.left);
						}
					}
		    	  
		      }
		      rev = !rev;
		      list.add(currentLevel);
		}
		return list;
    }
	//right side
	List<Integer> rightSide(TreeNode root){
		List<Integer> list = new ArrayList<>();
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int levelSize = q.size();
			for(int i =0; i<levelSize;i++) {
				TreeNode currentNode = q.poll();
				if(i == levelSize -1) {
					list.add(currentNode.value);
				}
								
				if (currentNode.left != null) {
			          q.offer(currentNode.left);
			        }
			        if (currentNode.right != null) {
			          q.offer(currentNode.right);
			        }
				
			}
		}
		return list;
	}
	boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root.left);
		q.add(root.right);
		while(!q.isEmpty()) {
			TreeNode left = q.poll();
			TreeNode right = q.poll();
			
			if(left == null && right == null) {
				continue;
			} 
			if(left == null || right == null) {
				return false;
			}
			if(left.value != right.value) {
				return false;
			}
			q.offer(left.left);
			q.offer(right.right);
			q.offer(left.right);
			q.offer(right.left);
			
		}
		return true;
	}
	int diam = 0;
	int diam(TreeNode root) {
		height(root);
		return diam -1;
	}
	private int height(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int lHeight = height(node.left);
		int rHeight = height(node.right);
		
		int diameter = lHeight + rHeight + 1;
		diam = Math.max(diam, diameter);
		
		return Math.max(lHeight, rHeight) +1;
	}
	public TreeNode invertTree(TreeNode root) {
		return postOrder(root);
	}
	private TreeNode postOrder(TreeNode root) {
		if(root == null) {
			return null;
		}
		TreeNode left = postOrder(root.left);
		TreeNode right = postOrder(root.right);
		
		root.left = right;
		root.right = left;
		return root;
	}
	public boolean hasPath(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		if(root.value == targetSum && root.left == null && root.right == null) {
			return true;
		}
		return hasPath(root.left, targetSum - root.left.value) || hasPath(root.right, targetSum - root.right.value);
	}
	
	public int sumNos(TreeNode root) {
		return helper(root,0);
	}
	private int helper(TreeNode root, int sum) {
		if(root == null) {
			return 0;
		}
		sum = sum *10+ root.value;
		
		if(root.left == null && root.right == null) {
			return sum;
		}
		
		return helper(root.left,sum) + helper(root.right,sum);
	}
	boolean isPathExists(TreeNode root, int[] arr) {
		return helper2(root,0,arr);
	}
	private boolean helper2(TreeNode root, int index, int[] arr) {
		if(arr.length == -1) {
			return false;
		}
		   if(arr[index] != root.value) {
			   if(root.left!=null) {
				   return helper2(root.left,index+1,arr);
			   }
			   return   helper2(root.right,index+1,arr);
		   } else {
			   return false;
		   }
		
		}
	boolean isSymmetric2(TreeNode root) {
		if(root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);
		while(!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			
			if(left.value != right.value) {
				return false;
			}
			if(left == null || right == null) return false;
			if(left == null && right == null) continue;
			
		
		queue.offer(left.left);
		queue.offer(right.right);
		queue.offer(left.right);
		queue.offer(right.left);
	}
		return true;
	}
	boolean isSymmetric3(TreeNode node) {
		TreeNode p = node.left;
		TreeNode q = node.right;
		return helper(p,q);
	}
	boolean helper(TreeNode p, TreeNode q) {
		if(p == null || q == null) return false;
		if(p == null && q == null) return true;
		
		return (p.value == q.value) && helper(p.left, q.right) && helper(p.right,q.left);
	}
	boolean isBalanced(TreeNode root) {
		return Math.abs(height2(root.left) - height2(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
				
	}
	int height2(TreeNode node) {
		if(node == null) return 0;
		return Math.max(height2(node.left) ,height2(node.right)) +1;
	}
	boolean pathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		if(root.value == sum && root.left == null && root.right == null) {
			return true;
		}
		return pathSum(root.left, sum - root.left.value) || pathSum(root.right, sum - root.right.value);
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		
		if(root == null) {
			return list;
		}
		
		String ans ="" + root.value;
		if(root.left == null && root.right == null) {
			list.add(ans);
		}
		ans = ans + "->";
		binaryTreePaths(root.left); 
		binaryTreePaths(root.right);
		return list;
		
	}
	static List<Integer> list = new ArrayList<>();
	public boolean isValidBSTInoder(TreeNode root) {
		inorder(root,list);
		return issorted();
		
	}	
	public static boolean issorted() {
		for(int i=0; i< list.size() -1;i++) {
			if(list.get(i) >= list.get(i + 1)) {
				return false;
			}
		}
		return true;
	}
	private static void inorder(TreeNode root, List<Integer> result) {
		if(root == null) {
			return;
		}
		inorder(root.left, result);
		result.add(root.value);
		inorder(root.right, result);
		
	}
	
}
