package Tree;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalTraversal {

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
	 public List<List<Integer>> verticalTraversal(TreeNode node) {
		    List<List<Integer>> ans = new ArrayList<List<Integer>>();

		    if (node == null) {
		      return ans;
		    }

		    int col = 0;

		    Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();
		    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

		    queue.offer(new AbstractMap.SimpleEntry<>(node, col));

		    int min = 0;
		    int max = 0;

		    while(!queue.isEmpty()) {
		      Map.Entry<TreeNode, Integer> removed = queue.poll();
		      node = removed.getKey();
		      col = removed.getValue();

		      if(node != null) {
		        if(!map.containsKey(col)) {
		          map.put(col, new ArrayList<Integer>());
		        }

		        map.get(col).add(node.value);

		        min = Math.min(min, col);
		        max = Math.max(max, col);

		        queue.offer(new AbstractMap.SimpleEntry<>(node.left, col-1));
		        queue.offer(new AbstractMap.SimpleEntry<>(node.right, col+1));
		      }
		    }

		    for(int i=min; i <= max; i++) {
		      ans.add(map.get(i));
		    }

		    return ans;
		  }
	}

