package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctSubarray {

	public static int longestDistinctSubarray(String s) {
		if(s == null || s.isEmpty()) {
			return 0;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0, end = 0, max = Integer.MIN_VALUE;
		while(end < s.length()) {
			if(!map.containsKey(s.charAt(end))) {
				map.put(s.charAt(end), end);
			} else {
				int lastOccurrence = map.get(s.charAt(end));
				while(start <= lastOccurrence) {
					map.remove(s.charAt(start));
					start++;
				}
				map.put(s.charAt(end), end);
			}
			end++;
			max = Math.max(max, end - start);
			
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(longestDistinctSubarray("fsfetwenwe"));
	}
}
