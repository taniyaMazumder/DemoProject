package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;

import Tree.BST.Node;


class BinaryTree {

  public BinaryTree() {

  }
  public static void main(String[] args) {
	      Scanner scanner = new Scanner(System.in);
	     BinaryTree tree1 = new BinaryTree();
	     tree1.populate(scanner);
	     tree1.prettyDisplay();
//	     
//	     BinaryTree tree2 = new BinaryTree();
//	     tree2.populate(scanner);
//	     tree2.prettyDisplay();
//	     System.out.println();
//	     System.out.println(isSameTree(tree1.root, tree2.root)); 
//	     System.out.println(maxPathSum(tree1.root));
	  //   System.out.println(pathSum3(root,8));
	//     System.out.println(Arrays.toString(findModeHashmap(root)));  
	    System.out.println(isSumTree(tree1.root));
	  
  }

  private static class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  private static Node root;

  // insert elements
  public void populate(Scanner scanner) {
    System.out.println("Enter the root Node: ");
    int value = scanner.nextInt();
    root = new Node(value);
    populate(scanner, root);
  }

  private void populate(Scanner scanner, Node node) {
    System.out.println("Do you want to enter left of " + node.value);
    boolean left = scanner.nextBoolean();
    if (left) {
      System.out.println("Enter the value of the left of " + node.value);
      int value = scanner.nextInt();
      node.left = new Node(value);
      populate(scanner, node.left);
    }

    System.out.println("Do you want to enter right of " + node.value);
    boolean right = scanner.nextBoolean();
    if (right) {
      System.out.println("Enter the value of the right of " + node.value);
      int value = scanner.nextInt();
      node.right = new Node(value);
      populate(scanner, node.right);
    }

  }

  public void display() {
    display(BinaryTree.root, "");
  }

  private void display(Node node, String indent) {
    if (node == null) {
      return;
    }
    System.out.println(indent + node.value);
    display(node.left, indent + "\t");
    display(node.right, indent + "\t");
  }

  public void prettyDisplay() {
    prettyDisplay(root, 0);
  }

  private void prettyDisplay(Node node, int level) {
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

  public void preOrder() {
    preOrder(root);
  }

  private void preOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.print(node.value + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  public void inOrder() {
    inOrder(root);
  }

  private void inOrder(Node node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.value + " ");
    inOrder(node.right);
  }

  public void postOrder() {
	  postOrder(root);
  }

  private void postOrder(Node node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.value + " ");
  }
  
  // issame tree validation
  
  public static boolean isSameTree(Node p, Node q) {
      
	  if(p == null && q == null ) {
          return true;
      } if(p == null || q == null ) {
          return false;
      }
      
      return p.value == q.value &&  isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
 
  // symmetric tree validation
    
  	public static boolean symmetricCheck(Node root) {
  		Queue<Node> queue = new LinkedList<>();
  		
  		queue.offer(root.left);
  		queue.offer(root.right);
		
		while(!queue.isEmpty()) {
			Node left = queue.poll();
			Node right = queue.poll();
			
			if(left == null && right == null) {
				continue;
			}
			if(left == null || right == null) {
				return false;
			}
			
			if(left.value != right.value) {
				return false;
			}
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
			
		}
		return true;
  	}
  	
  	// check balanced or not
  	public static boolean isBalanced(Node root) {
        if(root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public static int height(Node node){
        if(node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) +1;
    }
    
 // find min diff between two node's values
    // Intuition- 1. sort the BST, 2. Take a variable diff as infinite and check diff between each elements and update diff , 3. return diff 
		public static int minDistance(Node root) {
			List<Integer> list = new ArrayList<>();
			inorderT(root,list);
	        int diff = Integer.MAX_VALUE;
	        for (int index = 0; index < list.size() -1; index++) {
				if(list.get(index+1) - list.get(index) < diff) {
					diff = list.get(index+1) - list.get(index);
				}
			}
	        return diff;
		 }
		public static void inorderT(Node root, List<Integer> result) {
	        if (root == null) {
	            return;
	        }
	        inorderT(root.left,result);
	        result.add(root.value);
	        inorderT(root.right,result);
	        }
	
		// find max diff between two node's values
		public static int maxDistance(Node root) {
			List<Integer> result = new ArrayList<>();
			inorderT(root, result);
			int max = Integer.MIN_VALUE;
			
			for(int i =0; i< result.size()-1; i++) {
				if(result.get(i +1) - result.get(i) > max) {
					max = result.get(i +1) - result.get(i);
				}
			}
			return max;
		}
		public static int pathSum(Node root) {
			return helper(root,0);
		}
	 
		private static int helper(Node root, int sum) {
			if(root == null) {
				return 0;
			}
			sum = sum *10 + root.value;
			if(root.left == null && root.right == null) {
				return sum;
			}
			return helper(root.left, sum) + helper(root.right, sum);
		}
		public static List<String> binaryTreePaths(Node root) {
			List<String>  finalList = new ArrayList<>();
			String ans ="";
			finalList= helper(root, ans);
			return finalList;
		}
		private static List<String> helper(Node root, String result) {
			List<String> list = new ArrayList<>();
			if(root == null) 
			{
				return list;
			}
			
			result = result + root.value;
			if(root.left == null && root.right == null) {
				list.add(result);
			}
			result = result + "->";
			helper(root.left,result); 
			helper(root.right,result);
			return list;
			
		}
		 // find sum of left leaves
		public static int sumOfLeftLeaves(Node root) {
			if(root == null) {
				return 0;
			}
			int ans =0;
			
			if(root.left != null && root.left.left == null && root.left.right == null) {
				ans = ans + root.left.value;
			}
			ans = ans + sumOfLeftLeaves(root.left);	
			ans = ans + sumOfLeftLeaves(root.right);
			
			return ans;
		}
		// find modes with using HashMap
		static List<Integer> list = new ArrayList<>();
		static int[] result = new int[list.size()];
		static int max = Integer.MIN_VALUE;
		static HashMap<Integer,Integer> map = new HashMap<>();
		
		public static int[] findModeHashmap(Node root) {
	        findModeH(root);
	        List<Integer> arr=new ArrayList<>();
	        
	        for(int key : map.keySet()){
	            if(map.get(key)==max){
	                arr.add(key);
	            }
	        }
	        int ans[] = new int[arr.size()];
	        for(int i=0; i<ans.length; i++){
	            ans[i]=arr.get(i);
	        }
	        return ans;
	    }
		public static void findModeH(Node node) {
			if(node == null) {
				return ;
			}
			if(map.containsKey(node.value)) {
					map.put(node.value, map.get(node.value)+1);
			}
				else {
					map.put(node.value, 1);
				}
			if(map.get(node.value) > max) {
				max = map.get(node.value);
			}
			findModeH(node.left);
			findModeH(node.right);
		}
	// find modes without using HashMap
		static List<Integer> modes = new ArrayList<>();
		static int currentVal	=0;
		static int maxCount	=0;
		static int currentCount	=0;
		public static int[] findMode(Node root) {
			inorder(root);
			int[] result = new int[modes.size()];
			for (int i = 0; i < modes.size(); i++) {
				result[i] = modes.get(i);
			}
			return result;
	}	
		static void inorder(Node root) {
			
			if(root == null) {
				return;
			}
			inorder(root.left);
			
			currentCount =  (root.value== currentVal) ? currentCount +1  : 1;
			if(currentCount == maxCount) {
				modes.add(root.value);
			}
			if(currentCount > maxCount) {
				maxCount = currentCount;
				modes.clear();
				modes.add(root.value);
			}
			currentVal = root.value;
			inorder(root.right);
		}
		 static List<String> pathSumIIIRetPaths(Node root, int targetSum) {
		    	
		    	return getSum2(root, targetSum);
		    }

			private static List<String> getSum2(Node node, int sum) {
				List<String> paths = new ArrayList<>();
				String ans ="";
				
				if(node == null) return paths;
				
				ans = ans + node.value;
				
				getSum2(node.left,sum);
				getSum2(node.right,sum);
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
			public static int widthOfBinaryTree(Node root) {
		        if(root == null) {
		        	return 0;
		        }
		        Queue<Node> queue = new LinkedList<>();
		        queue.offer(root.left);
		        queue.offer(root.right);
		        
		        while(!queue.isEmpty()) {
		        	Node currentNode = queue.poll();
		        	if(currentNode.left == null && currentNode.right == null) {
		        		break;
		        	}
		        	queue.offer(currentNode.left);
		        	queue.offer(currentNode.right);
		        	
		        }
		        return queue.size() +1;
		    }
			public static int pathSum3(Node root, int targetSum) {
				return helper3(root,0,targetSum);
			}
		 
			private static int helper3(Node root, int sum, int target) {
				if(root == null || root.left == null && root.right == null) {
					return 0;
				}
				sum = sum  + root.left.value;
				int count =0;
				helper3(root.left, sum,target) ;
				 helper3(root.right, sum,target);
				 
				while(target == sum) {
					count++;
					break;
				}
				return count;
				
			}
			static boolean isSumTree(Node root) {
				if(root == null || root.left==null && root.right == null){
		            return true;
		        }
		        
		        int left = findSum(root.left);
		        int right = findSum(root.right);
		        
		        if((root.value == left +right) && (isSumTree(root.left)) && (isSumTree(root.right))) {
		        	return true;
		        }else {
		        	return false;
		        }
			}
			static int findSum(Node node) {
				if(node == null) {
					return 0;
				}
				return findSum(node.left) + node.value + findSum(node.right);
			}
	}
		

