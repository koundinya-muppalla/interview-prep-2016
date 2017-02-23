package honors;

import java.util.Arrays;
import java.util.Comparator;

public class KthSmallest {

    public static int kthSmallest(int[] arr, int k, Comparator<Integer> cmp) {
        if(arr == null || arr.length == 0 || k < 0) {
            return -1;
        }

        int start = 0, end = arr.length - 1;
        while(true) {
            int p = partition(arr, start, end, cmp);
            if(p == k - 1) {
                return arr[p];
            } else if (p > k - 1) {
                end = p - 1;
            } else {
                start = p + 1;
            }
        }
    }

    private static int partition(int[] arr, int low, int high, Comparator<Integer> cmp) {
        int pivot = arr[low];
        int i = low, j = high + 1;

        while(true) {
            while(i < high && cmp.compare(arr[++i], pivot) < 0) {
                if(i == high) {
                    break;
                }
            }

            while(j > low && cmp.compare(arr[--j], pivot) > 0) {
                if(j == low) {
                    break;
                }
            }

            if(i >= j) {
                break;
            }

            swap(arr, i, j);
        }

        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7,14,10,12,2,11,29,3,4};
        for(int i = 1; i <= arr.length; i++) {
            System.out.println("i=" + i + ": " + kthSmallest(Arrays.copyOf(arr, arr.length), i, new Comparator<Integer>() {

                public int compare(Integer o1,
                                   Integer o2) {
                    // TODO Auto-generated method stub
                    return Integer.compare(o1, o2);
                }
            }));
        }
    }
}
