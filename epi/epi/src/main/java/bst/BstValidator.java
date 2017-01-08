package bst;

import java.util.Stack;

public class BstValidator {

    public static boolean isBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBST(TreeNode root, long leftMax, long rightMin) {
        if(root == null) {
            return true;
        }

        if(root.data < leftMax || root.data > rightMin) {
            return false;
        }

        return isBST(root.left, leftMax, root.data) && isBST(root.right, root.data, rightMin);
    }

    private static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root, pre = null;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode top = stack.pop();
                if(pre != null && pre.data >= top.data) {
                    return false;
                }
                pre = top;
                curr = top.right;
            }
        }

        return true;
    }

}
