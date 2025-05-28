package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

public class PathSum {

	private static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int value) {
	      this.value = value;
	    }
	    
	  }
	// Find if the target is present as path in the binary tree or not
	public boolean hasPath(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		// while leaf nodes
		if(root.value == targetSum && root.left == null && root.right == null) {
			return true;
		}
		return hasPath(root.left, targetSum - root.left.value) || hasPath(root.right, targetSum - root.right.value);
	}
	
	// path sum- sum of all the paths and return the final sum
	public int pathSum(TreeNode root) {
		return helper(root,0);
	}
 
	private int helper(TreeNode root, int sum) {
		if(root == null) {
			return 0;
		}
		sum = sum *10 + root.value;
		if(root.left == null && root.right == null) {
			return sum;
		}
		return helper(root.left, sum) + helper(root.right, sum);
	}
	// check if the path exists or not which is available in the array
	public boolean isPathExists(TreeNode root, int[] arr) {
		if(root == null) {
			return arr.length ==0;
		}
		return helper(root, arr, 0);
		
	}

	private boolean helper(TreeNode root, int[] arr, int index) {
		if(index ==0) {
			return false;
		}
		if(root.left == null && root.right == null && index == arr.length -1 ) {
			return true;
		}
		if(index >= arr.length -1 && root.value != arr[index]) {
			return false;
		}
		return helper(root.left, arr, index +1) || helper(root.right, arr, index +1);
	}
	 public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		TreeNode left=	invertTree(root.left);
		TreeNode right=	invertTree(root.right);
		
		root.left = right;
		root.right = left;
		return root;
	}
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int ans =0;
		
		if(root.left != null && root.left.left == null && root.left.right == null) {
			ans = ans + root.value;
		}
		ans = ans + sumOfLeftLeaves(root.left);	
		ans = ans + sumOfLeftLeaves(root.right);
		
		return ans;
	}
	
	// find Binary Tree Max path sum
	static int ans = Integer.MIN_VALUE;
	public  static int maxPathSum(TreeNode root) {
		helper(root);
		return ans;
	}
	private static int helper(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int left = helper(node.left);
		int right =helper(node.right);
		
		// for negative value of node just ignore those nodes
		left = Math.max(0, left);
		right = Math.max(0, right);
		
		int pathSum = left + right + node.value;
		ans = Math.max(ans, pathSum);
		
		return Math.max(left, right) + node.value;
	}

	// Find longest path with same value of nodes
	static int pathCount = 0;
	public static int longestUnivaluePath(TreeNode root) {
		 helper2(root);
		return pathCount;
	}

	private static int helper2(TreeNode node) {
		if(node == null) return 0;
		
		// traversing to left and right
		int left = helper2(node.left);
		int right = helper2(node.right);
		
		int leftEdge =0;
		int rightEdge =0;
		
		// count the edges by 1 while moving down wards
		if(node.left != null && node.value == node.left.value) {
			leftEdge = leftEdge + left +1;
		}
		
		if(node.right != null && node.value == node.right.value) {
			rightEdge = rightEdge + right +1;
		}
		
		pathCount = Math.max(pathCount, leftEdge + rightEdge);
		return Math.max(leftEdge, rightEdge);
	}

	// check if target is satisfying to find the paths or not if it find then return how many paths sum = target
	//Time complexity= o(n^2) - space complexity - O(n)
	static int finalanswer = 0;
    public static int pathSumIII(TreeNode root, int targetSum) {
 	   if(root == null) {
 		   return 0;
 	   }
 	   answer(root,targetSum,0);
 	   pathSumIII(root.left, targetSum);
 	   pathSumIII(root.right, targetSum);
 	   return finalanswer;
    }
    public static void answer(TreeNode node, int targetSum, int currentSum) {
 	   if(node == null) {
 		   return;
 	   }
 	   currentSum += node.value;
 	   if(targetSum == currentSum) {
 		   finalanswer ++;
 	   }
 	   answer(node.left,targetSum,currentSum);
 	   answer(node.right,targetSum,currentSum);
 	 }
    // using list
    // //Time complexity= o(n) - space complexity - O(n)
    static ArrayList<Integer> list = new ArrayList<>();
    static int pathSumIIIUsingList(TreeNode root, int targetSum) {
    	getSum(root, targetSum);
    	return finalanswer;
    }

	private static void getSum(TreeNode node, int sum) {
		if(node == null) return;
		
		list.add(node.value);
		getSum(node.left,sum);
		getSum(node.right,sum);
		int tempSum =0;
		
		for(int i = list.size() -1; i>=0;i--) {
			tempSum += list.get(i);
			if(tempSum == sum) {
				finalanswer++;
			}
		}
		list.remove(list.size()-1); // after taking sum of paths, once done need to start to count for other path remove the previous paths from list
	}
	
	// using HashSet- TC-O(n), S(C) - o(n)
//	static int pathSumIIIHashSet(TreeNode root, int targetSum) {
//		HashSet<Integer> set = new HashSet<>();
//		return getHelper(root, targetSum, set);
//	}
//	static int getHelper(TreeNode node, int target, HashSet<Integer> set) {
//		if(node == null) {
//			return 0;
//		}
//		int count =0;
//		getHelper(node.left,target,set);
//		getHelper(node.right,target,set);
//		
//		set.add(target - node.value);
//		if(set.contains(node.value)) {
//			count++;
//			}
//		
//	}
	public int pathSum3(TreeNode root, int targetSum) {
		return helper3(root,0,targetSum);
	}
 
	private int helper3(TreeNode root, int sum, int target) {
		if(root == null) {
			return 0;
		}
		sum = sum  + root.value;
		int count =0;
		helper3(root.left, sum,target) ;
		 helper3(root.right, sum,target);
		 
		while(target == sum) {
			count++;
			break;
		}
		return count;
		
	}
	// Given : node & targetSum, find the paths which are equal to target and return those paths in list as string
	
    static List<String> pathSumIIIRetPaths(TreeNode root, int targetSum) {
    	
    	return getSum2(root, targetSum);
    }

	private static List<String> getSum2(TreeNode node, int sum) {
		List<String> paths = new ArrayList<>();
		String ans ="";
		
		if(node == null) return paths;
		
		ans = ans + node.value;
		
		getSum(node.left,sum);
		getSum(node.right,sum);
		int tempSum =0;
		
		for(int i = list.size() -1; i>=0;i--) {
			tempSum += list.get(i);
			if(tempSum == sum) {
				paths.add(ans);
			}
		}
		list.remove(list.size()-1); // after taking sum of paths, once done need to start to count for other path remove the previous paths from list
		return paths;
	}
	// check if target is satisfying to find the paths or not if it find then return how many paths sum = target
	//Time complexity= best case =O(nlogn)[if tree is balanced], worst case when tree is not balanced= O(n^2)
	//space complexity - best case- O(n), worst case- o(logn)
	
	public static int findCount(TreeNode root , int sum) {
		List<Integer> paths = new ArrayList<>();
		return helper4(root, sum, paths);
	}

	private static int helper4(TreeNode node, int targetSum, List<Integer> paths) {
		if(node == null)
			return 0;
		paths.add(node.value);
		int pathsum =0;
		int count =0;
		// how many paths we can make
		ListIterator<Integer> itr = paths.listIterator(paths.size());
		while(itr.hasPrevious()) {
			pathsum += itr.previous();
			if(pathsum == targetSum) {
				count++;
			}
		}
		
		count += helper4(node.left, targetSum, paths) + helper4(node.right, targetSum, paths);
		//backtrack
		paths.remove(paths.size() -1);
		return count;
	}
	// now print all the paths which can satisfy the targetsum and put in a list and return list<List<>>
	// Time & space complexity - o(nlogn)
	public static List<List<Integer>> findPaths(TreeNode root , int sum) { 
		List<List<Integer>> paths = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		helper5(root, sum, path, paths);
		return paths;
	}

	private static void helper5(TreeNode node, int targetSum, List<Integer> currentpath, List<List<Integer>> paths) {
		if(node == null)
			return;
		currentpath.add(node.value);
		// find how to get the complete path from only root to leaf
		if(node.left == null && node.right == null && node.value == targetSum) {
			paths.add(new ArrayList<>(currentpath));
		} else {
			helper5(node.left, targetSum - node.value, currentpath, paths);
			helper5(node.right, targetSum - node.value, currentpath, paths);
		}
		
		//backtrack
		paths.remove(paths.size() -1);
	}
}
