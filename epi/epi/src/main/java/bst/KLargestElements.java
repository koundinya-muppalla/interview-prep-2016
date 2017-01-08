package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KLargestElements {

    public static List<Integer> kLargestElements(TreeNode root, int k) {
        List<Integer> ret = new ArrayList<Integer>(k);
        if(root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.right;
            } else {
                TreeNode top = stack.pop();
                if(k > 0) {
                    ret.add(top.data);
                    k--;
                }

                if(k == 0) {
                    return ret;
                }

                curr = top.left;
            }
        }

        return ret;
    }

    public static void main(String[] args) {

    }
}
