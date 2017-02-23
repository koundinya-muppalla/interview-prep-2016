package honors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KClosestToMedian {

    public static List<Integer> kClosesToMedian(int[] arr, int k) {
        final int median = KthSmallest.kthSmallest(arr, (arr.length)/2 + 1, new Comparator<Integer>() {

            public int compare(Integer o1,
                               Integer o2) {
                // TODO Auto-generated method stub
                return Integer.compare(o1, o2);
            }
        });

        System.out.println("median: " + median);
        KthSmallest.kthSmallest(arr, k, new Comparator<Integer>() {

            public int compare(Integer o1,
                               Integer o2) {
                // TODO Auto-generated method stub
                return Integer.compare(Math.abs(o1 - median), Math.abs(o2 - median));
            }
        });
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < k; i++) {
            ret.add(arr[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {7,14,10,12,2,11,29,3,4,9};
        List<Integer> ret = kClosesToMedian(arr, 5);
        System.out.println(ret);
    }
}
