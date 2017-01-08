package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

    public static List<List<Integer>> permutation(int[] arr){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(arr == null || arr.length == 0) {
            return ret;
        }

        permutation(arr, 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    private static void permutation(int[] arr, int index, List<Integer> prefix, List<List<Integer>> ret) {
        if(index == arr.length) {
            ret.add(new ArrayList<Integer>(prefix));
            return;
        }

        Set<Integer> appeared = new HashSet<Integer>();
        for(int i = index; i < arr.length; i++) {
            if(appeared.contains(arr[i])) continue;
            appeared.add(arr[i]);
            prefix.add(arr[i]);
            swap(arr, i, index);
            permutation(arr, index + 1, prefix, ret);
            swap(arr, i, index);
            prefix.remove(prefix.size() - 1);

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        List<List<Integer>> permute = Permutation.permutation(arr);
        System.out.println(permute);
    }
}
