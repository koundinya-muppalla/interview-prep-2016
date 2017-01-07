package bst;

public class LCA {

	public TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
		if(root == null) {
			return null;
		}
		
		TreeNode curr = root;
		
		while(curr != null) {
			if(a.data < curr.data && b.data < curr.data) {
				curr = curr.left;
			} else if(a.data > curr.data && b.data > curr.data) {
				curr = curr.right;
			} else {
				break;
			}
		}
		
		
		return curr;
	}
}
