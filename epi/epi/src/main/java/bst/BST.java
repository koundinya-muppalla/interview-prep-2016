package bst;

public class BST {
	
	private TreeNode root;
	
	public BST() {
		root = null;
	}
	
	public void insert(int data) {
		root = insert(data, root);
	}
	
	private TreeNode insert(int data, TreeNode root) {
		if(root == null) {
			return new TreeNode(data);
		}
		
		if(data == root.data) {
			return root;
		} else if (data < root.data) {
			root.left = insert(data, root.left);
		} else {
			root.right = insert(data, root.right);
		}
		return root;
	}
	
	public void remove(int data) {
		root = remove(data, root);
	}
	
	private TreeNode remove(int data, TreeNode root) {
		if(root == null) {
			return null;
		}
		
		if(data < root.data) {
			root.left = remove(data, root.left);
		} else if (data > root.data) {
			root.right = remove(data, root.right);
		} else {
			if(root.right == null) {
				return root.left;
			}
			
			if(root.left == null) {
				return root.right;
			}

			TreeNode temp = root;
			root = min(temp.right);
			root.left = temp.left;			
			root.right = deleteMin(temp.right);
		}
		
		return root;
	}
	
	private TreeNode deleteMin(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		if(root.left == null) {
			return root.right;
		}
		
		root.left = deleteMin(root.left);
		return root;
	}
	private TreeNode min(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		if(root.left == null) {
			return root;
		}
		
		return min(root.left);
	}

}
