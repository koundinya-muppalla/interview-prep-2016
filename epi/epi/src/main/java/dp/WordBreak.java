package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	public static boolean isWordBreak(String word, Set<String> dict) {
		if(word == null || word.isEmpty()) {
			return true;
		}

		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		for(int i = 1; i <= word.length(); i++) {
			for(int j = i-1; j >= 0; j--) {
				if(dp[j] && dict.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[word.length()];
	}
	
	
	public static List<String> wordBreak(String word, Set<String> dict) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		return wordBreak(word, dict, map);
	}
	
	public static List<String> wordBreak(String word, Set<String> dict, Map<String, List<String>> map) {
		if(map.containsKey(word)) {
			return map.get(word);
		}
		
		List<String> ret = new ArrayList<String>();
		if(dict.contains(word)) {
			ret.add(word);
		}
		
		for(int i = 1; i <= word.length(); i++) {
			String prefix = word.substring(0, i);
			if(dict.contains(prefix)) {
				for(String subword : wordBreak(word.substring(i), dict, map)) {
					ret.add(prefix + " " + subword);
				}
			}
		}
		map.put(word, ret);
		return ret;
	}
	
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("bed");
		dict.add("bath");
		dict.add("and");
		dict.add("beyond");
		dict.add("hand");
		dict.add("bat");
		
		System.out.println(wordBreak("bedbathandbeyond", dict));
	}
}
