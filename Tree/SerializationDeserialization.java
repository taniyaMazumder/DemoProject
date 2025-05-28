package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializationDeserialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    public TreeNode(int val) {
	      this.val = val;
	    }
	  }
	
	public static List<String> serialize(TreeNode root) {
		List<String> list = new ArrayList<>();
		helper(list, root);
		return list;
    }

	private static void helper(List<String> list, TreeNode node) {
		if(node == null) {
			list.add("null");
			return;
		}
		
		list.add(String.valueOf(node.val));
		
		helper(list, node.left);
		helper(list, node.right);
	}
	
	public static TreeNode deserialize(List<String> listDes) {
		Collections.reverse(listDes);
		TreeNode node = helper2(listDes);
		return node;
	}

	private static TreeNode helper2(List<String> listDes) {
		String val = listDes.remove(listDes.size() -1);
		
		if(val.charAt(0) == 'n') {
			return null;
		}
		TreeNode node = new TreeNode(Integer.parseInt(val));
		node.left = helper2(listDes);
		node.right = helper2(listDes);
		
		return node;
	}
	// Leetcode submission
	
	 // Encodes a tree to a single string.
    public String serializeLeetCode(TreeNode root) {
    	StringBuilder sb = new StringBuilder(String.valueOf(root.val));
    	helper3(sb, root);
		return sb.toString();
    }

	private void helper3(StringBuilder str, TreeNode node) {
		if(node == null) {
			str.append("null");
			return;
		}
		str.append(String.valueOf(node.val));
		
		helper3(str, node.left);
		helper3(str, node.right);
	}
	public static TreeNode deserializeLeetCode(String data) {
		StringBuilder sb = new StringBuilder(data);
		sb.reverse();
		TreeNode node = helper4(sb.toString());
		return node;
	}

	private static TreeNode helper4(String str) {
		
		StringBuilder sb = new StringBuilder(str);
		
		String val = sb.deleteCharAt(sb.length() -1).toString();
		
		if(val.charAt(0) == 'n') {
			return null;
		}
		
		TreeNode node = new TreeNode(Integer.parseInt(val));
		node.left = helper4(sb.toString());
		node.right = helper4(sb.toString());
		
		return node;
	}
}
