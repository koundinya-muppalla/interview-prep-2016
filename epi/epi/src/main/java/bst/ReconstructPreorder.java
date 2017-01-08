package bst;

import java.util.LinkedList;
import java.util.Queue;

public class ReconstructPreorder {

    public static TreeNode reconstructPreOrder(int[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }

        return reconstruct(arr, 0, arr.length - 1);
    }

    private static TreeNode reconstruct(int[] arr, int start, int end) {
        if(start > end) {
            return null;
        }

        if(start == end) {
            return new TreeNode(arr[start]);
        }

        TreeNode root = new TreeNode(arr[start]);
        int right = start + 1;
        while(right <= end && arr[right] < arr[start]) {
            right++;
        }

        root.left = reconstruct(arr, start + 1, right - 1);
        root.right = reconstruct(arr, right, end);
        return root;
    }

    public static TreeNode reconstruct(int[] arr) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int num : arr) {
            queue.offer(num);
        }

        return reconstruct(queue, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static TreeNode reconstruct(Queue<Integer> queue, long min, long max) {
        if(queue.isEmpty()) {
            return null;
        }

        if(queue.peek() < min || queue.peek() > max) {
            return null;
        }

        TreeNode root = new TreeNode(queue.poll());
        root.left = reconstruct(queue, min, root.data);
        root.right = reconstruct(queue, root.data, max);
        return root;
    }
}
