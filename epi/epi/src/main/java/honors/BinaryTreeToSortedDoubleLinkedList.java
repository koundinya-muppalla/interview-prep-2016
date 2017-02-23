package honors;

public class BinaryTreeToSortedDoubleLinkedList {

    public static TreeNode toDLL(TreeNode root) {
        if(root == null) {
            return root;
        }

        if(root.left != null) {
            TreeNode left = toDLL(root.left);
            while(left != null && left.right != null) {
                left = left.right;
            }

            left.right = root;
            root.left = left;
        }

        if(root.right != null) {
            TreeNode right = toDLL(root.right);
            while(right != null && right.left != null) {
                right = right.left;
            }

            right.left = root;
            root.right = right;
        }

        return root;
    }
    private static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
