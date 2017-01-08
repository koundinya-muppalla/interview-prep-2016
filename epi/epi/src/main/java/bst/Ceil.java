package bst;

public class Ceil {

    public TreeNode ceil(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode ceil = null;
        while(curr != null) {
            if(curr.data == val) {
                ceil = curr;
                curr = curr.right;
            } else if (val < curr.data) {
                ceil = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return ceil;
    }
}
