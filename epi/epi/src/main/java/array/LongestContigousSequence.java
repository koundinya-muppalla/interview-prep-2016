package array;

public class LongestContigousSequence {

    public static int longestContigousSequence(int[] arr) {
        if(arr == null) {
            return 0;
        }

        if(arr.length <= 1) { 
            return arr.length;
        }

        int start = 0, end = 1, max = 1;
        while(end < arr.length) {
            if(arr[end] == arr[end - 1] + 1) {
                max = Math.max(max, end - start + 1);
            } else {
                start = end;
            }
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8};
        System.out.println(longestContigousSequence(arr));
    }
}
