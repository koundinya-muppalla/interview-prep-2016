package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreak1 {
    
    
    public boolean wordBreakDPSuffix(String s, Set<String> dict) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        return wordBreakDPSuffixUtil(s, dict, map);
    }
    
    private boolean wordBreakDPSuffixUtil(String s, Set<String> dict, Map<String, Boolean> map) {
        // If we know previously about the
        // result of this string, just return that
        if(map.containsKey(s)) {
            return map.get(s);
        }
        
        // If the dict contains this string,
        // add it to map and return
        if(dict.contains(s)) {
            map.put(s, true);
            return true;
        }
        
        for(int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            // If prefix is in dict
            if(dict.contains(prefix)) {
                String suffix = s.substring(i);
                // check for suffix
                if(wordBreakDPSuffixUtil(suffix, dict, map)) {
                    // both prefix and suffix are in dict,
                    // so add it to map and return true
                    map.put(s, true);
                    return true;
                }
            }
        }
        // Tried all combinations, then this
        // string is not valid
        map.put(s, false);
        return false;
    }
    
    public boolean wordBreakDPPrefix(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++) {
            for(int j = i-1; j>=0; j--) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true; 
                }
            }
        }
        return dp[s.length()];
    }
}
