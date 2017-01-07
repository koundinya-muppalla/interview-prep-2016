package binarytree;


public class KthInorderNode {
	
	public TreeNode findKthInorder(TreeNode root, int k) {
		if(root == null) {
			return null;
		}
		
		if(k == 0) {
			return root;
		}
		
		int left = root.left == null ? 0 : root.left.numChildren + 1;
		
		if(k == left + 1) {
			return root;
		}
		
		if(k > left + 1) {
			return findKthInorder(root.right, k - (left + 1));
		} else {
			return findKthInorder(root.left, k);
		}
	}

	private class TreeNode {
		int numChildren;
		int val;
		TreeNode left;
		TreeNode right;
	}
}

