package PracticeForInterview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static class Node {
	int value;
    Node left;
    Node right;
    int height;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  private static Node root;
	static int height(Node node) {
		if(node== null) return -1;
		return node.height;
	}
	static boolean balanced(Node root) {
		if(root==null) return true;
		return Math.abs(height(root.left) - height(root.right)) <=1 && balanced(root.left) && balanced(root.right);
	}
	static Node insertSort(int[] ar) {
		
		return helper(ar,0,ar.length);
		
	}
	private static Node helper(int[] ar, int start, int end) {
		if(start >end) {
			return null;
		}
		int mid= (start + end) /2;
		Node node =new Node(ar[mid]);
		helper(ar,start,mid);
		helper(ar,mid+1,end);
		
		return node;
	}
	// check BST using preOrder
	static boolean preOrder(Node root, Integer low, Integer high) {
		if(root == null) {
			return true;
		}
		if(low!= null && root.value <= low) {
			return false;
		}
		if(high!=null && root.value >=high) {
			return false;
		}
		return preOrder(root.left,low,root.value) && preOrder(root.right,root.value,high);
	}
	/*
	 * BFS
	 */
	static List<List<Integer>> bfs(Node node) {
		List<List<Integer>> list = new ArrayList<>();
		if(node==null) return list;
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> internal = new ArrayList<>(size);
			
			for (int i = 0; i < size; i++) {
				Node current = q.poll();
				internal.add(current.value);
				if(current.left != null) {
					q.offer(current.left);
				}
				if(current.right != null) {
					q.offer(current.right);
				}
			}
			list.add(internal);
		}
		return list;
		
	}
	/*
	 *   avg level of BT
	 */
	static List<Double> avg(Node root) {
		List<Double> list = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			double sum =0;
			
			for(int i=0; i< size;i++){ 
			Node current = q.poll();
			sum = sum +current.value;
			
			if(current.left!= null) {
				q.offer(current.left);
			}
			if(current.right!= null) {
				q.offer(current.right);
			}
			}
			sum = sum/ size;
			list.add(sum);
		}
		return list;
	}
	/*
	 * level order successor
	 */
	static Node levelOrder(Node root, int k) {
		if(root==null) {
			return null;
		}
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node currentNode = q.poll();
			if(currentNode.left != null) {
			 	 q.offer(currentNode.left);
			 }
			 if(currentNode.right != null) {
				 q.offer(currentNode.right);
			 } 
			 if(currentNode.value ==k) {
				 break;
			 }
		}
		return q.peek();
	}
	// zigzag order
  public List<List<Integer>> zigzag(Node root){
		
		List<List<Integer>> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		Deque<Node> deq = new LinkedList<>();
		deq.offer(root);
		
		while(!deq.isEmpty()) {
			int size = deq.size();
			List<Integer> temp = new ArrayList<>(size);
			boolean rev = false;
			for (int i = 0; i < size; i++) {
				
				if(!rev) {
					Node current = deq.pollFirst();
					temp.add(current.value);
					if(current.left!=null) {
						deq.addLast(current.left);
					}
					if(current.right!=null) {
						deq.addLast(current.right);
					}
				}else {
					Node current = deq.pollLast();
					temp.add(current.value);
					if(current.left!=null) {
						deq.addFirst(current.left);
					}
					if(current.right!=null) {
						deq.addFirst(current.right);
					}
				}
			}
			rev = !rev;
			list.add(temp);
		}
		return list;
   }
  /* next right pointer
   * 
   */
  static Node connect(Node root) {
	  if(root == null) return root;
	  Node current = root;
	  
	  while(current!= null) {
		  Node temp = current;
		  while(temp!= null) {
			  temp.left.next = current.right;
			  if(temp.next!= null) {
				  temp.right.next = temp.next.left;
			  }
			  temp = temp.next;
		  }
		   current = current.next;
	 }
	return root;
  }
  // right side view
  
  static List<Integer> right(Node root) {
	  List<Integer> result = new ArrayList<>();
	  if(root == null) return result;
	  Node current = root;
	  Queue<Node> q = new LinkedList<>();
	  q.offer(root);
	  
	  while(!q.isEmpty()) {
		  int size = q.size();
		  for(int i=0;i<size;i++) {
			  Node currentNode = q.poll();
			  if(i == size-1) {
				  result.add(currentNode.value);
			  }
			  if(currentNode.left != null) {
				 	 q.offer(currentNode.left);
				 }
				 if(currentNode.right != null) {
					 q.offer(currentNode.right);
				 } 
				 
		  }
		  
	  }
	return result;
  }
  /*
   *  find out siblings or not
   */
  public boolean iscousin(Node root, int x, int y) {
	  Node xx= find(root,x);
	  Node yy = find(root,y);
	  
	  return (level(root,xx,0) == level(root,yy,0)) && !sibling(root.left,xx,yy) && !sibling(root.right,xx,yy);
	  
  }
 private int level(Node root, Node xx, int level) {
	if(root == null) return 0;
	if(root ==xx) {
		return level;
	}
	int left = level(root.left,xx,0);
	if(left !=-1) {
		return left;
	}
	return level(root.right,xx,0);
	
}
 boolean sibling(Node root, Node x, Node y ) {
	 if(root == null) return false;
	 return (root.left == x && root.right ==y ) || (root.left == y && root.right ==x) || sibling(root.left,x,y) || sibling(root.right,x,y);
 }
private Node find(Node root, int x) {
	if(root == null) {
		return root;
	}
	if(root.value ==x) {
		return root;
	}
	Node left= find(root.left,x);
	if(left!= null) {
		return left;
	}
	return find(root.right,x);
}
// symmetric tree
static boolean symmetric(Node root) {
	if(root.left == null && root.right == null) {
		return root.left == root.right;
	}
	return helperTree(root.left,root.right);
}
private static boolean helperTree(Node p, Node q) {
	if(p== null && q== null) {
		return true;
	}
	if(p== null || q== null) {
		return false;
	}
	return p==q || helperTree(p.left,q.right) || helperTree(p.right,q.left);
}

// diamter
static int diam =0;
static int diameter(Node root) {
	helperDia(root);
	return diam-1;
}
private static int helperDia(Node root) {
	if(root== null) {
		return 0;
	}
	int left = helperDia(root.left);
	int right = helperDia(root.right);
	
	int temp =  Math.max(left, right)+1;// through temp ans
    int ans = Math.max(temp, 1+ left+right);  // through root ans
	diam= Math.max(ans, diam); 
	return temp;
}
// max path sum from any node to any node
static int res=0;
public static int maxPathSum(Node root) {
	solve(root);
	return res ;
}
private static int solve(Node root) {
	// base condition
	if(root == null) {
		return 0;
	}
	int left = solve(root.left);
	int right = solve(root.right);
	
	int temp= Math.max(Math.max(left, right) + root.value,root.value);
	int ans= Math.max(temp, left+right+root.value);
	res= Math.max(ans, res);
	
	return temp;
   }
//max path sum from leaf node to leaf node
static int res2=0;
public static int maxPathSumleaf(Node root) {
	solveleaf(root);
	return res2 ;
}
private static int solveleaf(Node root) {
	// base condition
	if(root == null) {
		return 0;
	}
	int left = solveleaf(root.left);
	int right = solveleaf(root.right);
	
	int temp= Math.max(left, right) + root.value;
	int ans= Math.max(temp, left+right+root.value);
	res2= Math.max(ans, res);
	
	return temp;
}
//max path sum from leaf node to root node
static int res3=0;
static int maxSum = Integer.MIN_VALUE;
public static int maxPathSumRoot(Node root) {
	solveRoot(root,0);
	return maxSum ;
}
private static void solveRoot(Node root, int currSum) {
	// base condition
	if(root == null) {
		return ;
	}
	
	currSum += root.value;
	
	if(root.left == null && root.right == null) {
		maxSum = Math.max(maxSum, currSum);
	}
	solveRoot(root.left,currSum);
	solveRoot(root.right,currSum);
}
// convert BST to LL
public static void flatten(Node root) {
    
    // pre-order // to get rightmost node and link with the original right nodes to it
	Node current = root;
	while(current != null) {
		if(current.left != null) {
			Node temp = current.left;
			while(temp.right!= null) {
				temp = temp.right;
			}
			temp.right = current.right;
			current.right = current.left;
			current.left = null;
		}
		current = current.right;
	}
  }

static Node deleteANode(Node root, int key) {
	if(root == null) {
		return null;
	}
	//	while(current != null) {
//		if(current.left!=null) {
//			Node temp = current.left;
//			if(temp.value == key) {
//				current.left = temp.left;
//				while(temp.right != null) {
//					temp = temp.right;
//					}
//				temp.right = current.right;
//			}
//		}
	if(root.value == key) {
		return helperDelete(root);
	}
	Node dummy = root;
	while(root != null)	{
		if(root.value > key) {
			if(root.left != null && root.left.value == key) {
				root.left = helperDelete(root.left);
				break;
			} else {
				root = root.left;
			}
		} else {
			if(root.right != null && root.right.value == key) {
				root.right = helperDelete(root.right);
				break;
			} else {
				root = root.right;
			}
		}
		
	  }
	return dummy;
	}


private static Node helperDelete(Node root) {
	if(root.left == null) {
		return root.right;
	}
	else if(root.right == null) {
		return root.left;
	}else {
		Node rightChild = root.right;
		Node lastrightroot = findLastRoot(root.left);
		lastrightroot.right = rightChild;
		return root.left;
		
	}
	
}
private static Node findLastRoot(Node root) {
	if(root == null) {
		return root;
	}
	return findLastRoot(root.right);
}
// LCA
static Node LCA(Node root, Node p, Node q) {
	if(p == null && q==null) {
		return root;
	}
	if(root== p || root== q) {
		return root;
	}
	Node left = LCA(root.left,p,q);
	if(left !=null) {
		return left;
	}
	return LCA(root.right,p,q);
}
// kth smallest using inorder traversal
static int count=0;
static int kthSmallest(Node root, int k) {
	if(root ==null) return 0;
	int left = kthSmallest(root.left,k);
	
	if(left!=0) {
		return left;
	}
	count++;
	if(count==k) {
		return root.value;
	}
	
	int right = kthSmallest(root.right,k);
	return right;
	
  }
// path sum

  static boolean hasPath(Node root, int target) {
	if(root == null) {
		return false;
	}
	if(target== root.value && root.left ==null && root.right==null) {
		return true;
	}
	return hasPath(root.left,target-root.left.value) || hasPath(root.right,target-root.right.value);
   }
  
  // pathsum root to leaf
  static int sum=0;
  static int pathsum2(Node root) {
	  if(root==null) {
		  return 0;
	  }
	  sum = sum *10+ root.value;
	  if(root.left == null && root.right == null) {
		  return sum;
	  }
	  return  pathsum2(root.left) + pathsum2(root.right);
	  
  }
  static boolean isCheckArray(Node root, int[] ar, int index) {
	  if(root ==null) return false;
	  if(index> ar.length-1 && ar[index]!= root.value) {
		  return false;
	   }
	  if(root.left == null && root.right == null && index== ar.length-1) {
		  return true;
	  }
	  return isCheckArray(root.left,ar,index+1) || isCheckArray(root.right,ar,index+1);
  }
  // path exists as equal to target
  static int findCountPath(Node root, int target) {
	  List<Integer> paths = new ArrayList<>();
	  return helperCount(root,target,paths);
  }
  private static int helperCount(Node root, int target, List<Integer> paths) {
	if(root == null) {
		return 0;
	}
	paths.add(root.value);
	int count=0;
	int pathSum=0;
	ListIterator<Integer> itr = paths.listIterator(paths.size());
	while(itr.hasPrevious()) {
		pathSum += itr.previous();
		if(pathSum == target) {
			count++;
		}
	}
	 count += helperCount(root.left,target,paths) + helperCount(root.right,target,paths);
	 paths.remove(paths.size()-1);
	return count;
}
  public static List<List<Integer>> findPaths(Node root , int sum) { 
		List<List<Integer>> paths = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		helperPathRet(root, sum, path, paths);
		return paths;
	}
private static void helperPathRet(Node root, int target, List<Integer> path, List<List<Integer>> paths) {
	if(root ==null) {
		return ;
	}
	path.add(root.value);
	if(root.left == null && root.right == null && root.value == target) {
		paths.add(new ArrayList<>(path));
	} else {
		helperPathRet(root.left,target-root.left.value,path,paths);
		helperPathRet(root.right,target-root.right.value,path,paths);
	}
	path.remove(path.size()-1);
	
}
   static boolean twoSum(Node root, int k) {
	   HashSet<Integer> set = new HashSet<>();
	   return helperTwoSum(root,k,set);
  }
private static boolean helperTwoSum(Node root, int k, HashSet<Integer> set) {
	if(root == null) {
		return false;
	}
	if(set.contains(k-root.value)) {
		return true;
	}
	set.add(root.value);
	
	return helperTwoSum(root.left ,k,set) || helperTwoSum(root.right ,k,set);
}
}
