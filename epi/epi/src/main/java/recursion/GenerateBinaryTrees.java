package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryTrees {


    public static List<TreeNode> generateBinaryTrees(int n) {
        List<TreeNode> ret = new ArrayList<GenerateBinaryTrees.TreeNode>();
        if(n <= 0) {
            return ret;
        }

        for(int left = 0; left < n; left++) {
            int right = n - left -1;
            List<TreeNode> leftSubTree = generateBinaryTrees(left);
            List<TreeNode> rightSubTree = generateBinaryTrees(right);

            for(TreeNode leftNode : leftSubTree) {
                for(TreeNode rightNode : rightSubTree) {
                    ret.add(new TreeNode(0, leftNode, rightNode));
                }
            }
        }
        return ret;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
