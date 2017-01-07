package bst;

public class Search {

	public TreeNode search(TreeNode root, int key) {
		TreeNode curr = root;
		TreeNode res = null;
		while(curr != null) {
			if(key == curr.data) {
				res = curr;
				curr = curr.left;
			} else if (key > curr.data) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		
		return res;
	}
}
