package bst;

import java.util.Stack;

public class AreOrdered {

	public boolean areOrdered(TreeNode a, TreeNode b, TreeNode middle) {
		if(middle.data == a.data || middle.data == b.data) {
			return false;
		}
		TreeNode curr = middle;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode child = null, parent = null;
		while(curr != null || !stack.isEmpty()) {
			if(curr != null) {
				stack.push(curr);
				if(curr.data == a.data) {
					child = a;
					parent = b;
					break;
				} else if (curr.data == b.data) {
					child = b;
					parent = a;
					break;
				}
				curr = curr.left;
			} else {
				TreeNode top = stack.pop();
				curr = top.right;
			}
		}
		
		if(child == null && parent == null) {
			return false;
		}
		
		curr = parent;
		stack.clear();
		
		while(curr != null || !stack.isEmpty()) {
			if(curr != null) {
				stack.push(curr);
				if(curr.data == middle.data) {
					return true;
				}
				curr = curr.left;
			} else {
				TreeNode top = stack.pop();
				curr = top.right;
			}
		}
		
		return false;
	}
}
