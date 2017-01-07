package binarytree;

import java.util.ArrayList;
import java.util.List;

public class InOrderParentPointer {
	
	public static List<Integer> inorder(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if(root == null) {
			return ret;
		}
		
		TreeNode curr = root;
		while(curr != null) {
			while(curr.left != null) {
				curr = curr.left;
			}
			
			ret.add(curr.val);
			while(curr.parent != null && curr == curr.parent.right) {
				curr = curr.parent;
			}
			curr = curr.parent;
			if(curr != null) {
				ret.add(curr.val);
				curr = curr.right;
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		TreeNode hundred = new TreeNode(100, null);
		
		TreeNode fifty = new TreeNode(50, hundred);
		TreeNode twohundred = new TreeNode(200, hundred);
		hundred.left = fifty;
		hundred.right = twohundred;
		
		TreeNode t25 = new TreeNode(25, fifty);
		TreeNode t75 = new TreeNode(75, fifty);
		fifty.left = t25;
		fifty.right = t75;
		
		TreeNode t60 = new TreeNode(60, t75);
		TreeNode t80 = new TreeNode(80, t75);
		t75.left = t60;
		t75.right = t80;
		
		TreeNode t150 = new TreeNode(150, twohundred);
		TreeNode t250 = new TreeNode(250, twohundred);
		twohundred.left = t150;
		twohundred.right = t250;
		
		System.out.println(inorder(hundred));
	}
	
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		
		public TreeNode(int val, TreeNode parent) {
			this.val = val;
			this.parent = parent;
		}
	}
}
