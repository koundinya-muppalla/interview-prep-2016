package binarytree;

import java.util.ArrayList;
import java.util.List;

import bst.TreeNode;

public class Boundary {

    public static List<Integer> boundary(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) {
            return ret;
        }

        ret.add(root.data);
        leftBoundary(root.left, ret);
        leaves(root.left, ret);
        leaves(root.right, ret);
        rightBoundary(root.right, ret);
        return ret;
    }

    private static void leftBoundary(TreeNode root, List<Integer> ret) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            ret.add(root.data);
            leftBoundary(root.left, ret);
        } else {
            ret.add(root.data);
            leftBoundary(root.right, ret);
        }
    }

    private static void rightBoundary(TreeNode root, List<Integer> ret) {
        if(root == null) {
            return;
        }

        if(root.right != null) {
            rightBoundary(root.right, ret);
            ret.add(root.data);
        } else {
            rightBoundary(root.left, ret);
            ret.add(root.data);
        }
    }

    private static void leaves(TreeNode root, List<Integer> ret) {
        if(root == null) {
            return;
        }

        leaves(root.left, ret);
        if(root.left == null && root.right == null) {
            ret.add(root.data);
            return;
        }
        leaves(root.right, ret);
    }
}
