package bst;

import java.util.ArrayList;
import java.util.List;

public class IntervalSearch {

    public static List<Integer> search(TreeNode root, int start, int end) {
        List<Integer> ret = new ArrayList<Integer>();
        search(root, start, end, ret);
        return ret;
    }

    private static void search(TreeNode root, int start, int end, List<Integer> ret) {
        if(root == null || start > end) {
            return;
        }

        if(root.data >= start && root.data <= end) {
            search(root.left, start, root.data);
            ret.add(root.data);
            search(root.right, root.data, end);
        } else if (root.data < start) {
            search(root.right, root.data, end);
        } else {
            search(root.left, start, root.data);
        }
    }
}
