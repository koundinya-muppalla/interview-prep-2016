package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
	
	public static List<List<Integer>> powerset(int[] arr) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(arr == null || arr.length == 0) {
			return ret;
		}
		
		Arrays.sort(arr);
		powerset(arr, 0, new ArrayList<Integer>(), ret);
		return ret;
	}
	
	private static void powerset(int[] arr, int index, List<Integer> prefix, List<List<Integer>> ret) {
		if(index > arr.length) {
			return;
		}
		
		ret.add(new ArrayList<Integer>(prefix));
		
		for(int i = index; i < arr.length; i++) {
			if(i != index && arr[i] == arr[i -1]) continue;
			prefix.add(arr[i]);
			powerset(arr, i + 1, prefix, ret);
			prefix.remove(prefix.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,2};
		System.out.println(powerset(arr));
	}

}
