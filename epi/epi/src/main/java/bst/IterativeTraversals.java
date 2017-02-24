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

    public List<Integer> postOrder2(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                // If right is not null, push right first
                if(curr.right != null) {
                    stack.push(curr.right);
                }
                // then push curr
                stack.push(curr);

                // keep going left
                curr = curr.left;
            } else {
                TreeNode top = stack.pop();
                // If stack is empty or the top.right is not equal to peek
                // then add it to output
                if(stack.isEmpty() || top.right != stack.peek()) {
                    ret.add(top.val);
                } else {
                    // This is very important, top.right is equal to stack.peek(),
                    // since we pushed right first and root next, so we need to process
                    // right first, so pop it, make right as current and push the root
                    // back to stack
                    curr = stack.pop();
                    stack.push(top);
                }
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
