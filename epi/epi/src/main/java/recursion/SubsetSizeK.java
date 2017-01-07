package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSizeK {

	public static List<List<Integer>> subsetsSizeK(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(n == 0) {
			return ret;
		}
		subsets(n, k, 1, new ArrayList<Integer>(), ret);
		return ret;
	}
	
	private static void subsets(int n, int k, int index, List<Integer> prefix, List<List<Integer>> ret) {		
		if(prefix.size() == k) {
			ret.add(new ArrayList<Integer>(prefix));
			return;
		}
		
		for(int i = index; i <= n; i++) {
			prefix.add(i);
			subsets(n, k, i + 1, prefix, ret);
			prefix.remove(prefix.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(subsetsSizeK(5, 2));
	}
}
