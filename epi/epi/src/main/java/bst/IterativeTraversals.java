package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversals {

    public List<Integer> inorder(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            // If curr is not null, push it to stack
            // and go left
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                // when curr is null, we are at the left most node
                // pop it and the start going right
                TreeNode top = stack.pop();
                // Add it to output when we reach left most first
                ret.add(top.val);
                curr = top.right;    
            }
        }
        return ret;
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                // Since it is preorder, do the same as
                // in order but just add it to output while
                // pushing it to stack
                ret.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode top = stack.pop();
                curr = top.right;
            }
        }
        return ret;
    }

    public List<Integer> postorder(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        if(root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            if(curr!= null) {
                // Same as preorder, except add the result
                // to a linkedlist head so that the output
                // is in reverse order
                stack.push(curr);
                ret.addFirst(curr.val);

                // Also flip the order, in postorder
                // first go right coz the order we are interested
                // is left right root, and since we are adding from the
                // back first add root, then go right and then go left
                curr = curr.right;
            } else {
                TreeNode top = stack.pop();
                curr = top.left;
            }
        }
        return ret;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
