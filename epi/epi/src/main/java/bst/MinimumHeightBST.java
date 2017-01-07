package bst;

public class MinimumHeightBST {
	
	public TreeNode build(int[] arr) {
		if(arr == null || arr.length == 0) return null;
		
		return build(arr, 0, arr.length - 1);
	}
	
	private TreeNode build(int[] arr, int start, int end) {
		if(start > end) {
			return null;
		}
		
		int mid = start + (end - start)/2;
		TreeNode root = new TreeNode(mid);
		root.left = build(arr, start, mid - 1);
		root.right = build(arr, mid + 1, end);
		return root;
	}
}
