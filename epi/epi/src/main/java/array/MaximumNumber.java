package array;

import java.util.Stack;

public class MaximumNumber {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ret = new int[k];


        int n = nums1.length;
        int m = nums2.length;

        for(int i = Math.max(0, k-m); i <=n && i <=k; i++) {
            int[] candidate1 = max(nums1, i);
            int[] candidate2 = max(nums2, k - i);
            int[] cand = merge(candidate1, candidate2, k);
            if(greater(cand, 0, ret, 0)) {
                ret = cand;
            }
        }
        return ret;
    }


    private static int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for(int i = 0, j = 0, r = 0; r < k; r++) {
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    private static boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while(i < nums1.length && j < nums2.length && nums1[i] == nums2[i]) {
            i++;
            j++;
        }

        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    public static int[] max(int[] arr, int k) {
        int[] ret = new int[k];
        Stack<Integer> stack = new Stack<Integer>();
        int len = arr.length;
        for(int i = 0; i < arr.length; i++) {

            while(!stack.isEmpty() && stack.peek() < arr[i] && len - i + stack.size() > k) {
                stack.pop();
            }

            if(stack.size() < k) {
                stack.push(arr[i]);
            }
        }

        int i = k;
        while(!stack.isEmpty()) {
            ret[--i] = stack.pop();
        }
        return ret;
    }
}
