package sorting;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

    public static List<Integer> intersection(int[] arr1, int[] arr2) {
        List<Integer> ret = new ArrayList<Integer>();
        int i = 0, j = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] == arr2[j]) {
                ret.add(arr1[i]);
                i++;
                j++;
            } else if(arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }

            while(i > 0 && i < arr1.length && arr1[i] == arr1[i-1]) {
                i++;
            }
            while(j > 0 && j < arr2.length && arr2[j] == arr2[j-1]) {
                j++;
            }		

        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,3,5,5,6,7,7,8,12};
        int[] arr2 = {5,5,6,8,8,9,10,10};
        System.out.println(intersection(arr1, arr2));
    }
}
