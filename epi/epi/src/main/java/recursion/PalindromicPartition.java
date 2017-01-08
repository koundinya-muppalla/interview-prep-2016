package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {

    public static List<List<String>> palindromePartition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if(s == null || s.isEmpty()) {
            return ret;
        }
        partition(s, new ArrayList<String>(), ret);
        return ret;
    }

    private static void partition(String s, List<String> temp, List<List<String>> ret) {
        if(s == null || s.isEmpty()) {
            ret.add(new ArrayList<String>(temp));
            return;
        }

        for(int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if(isPalindrome(prefix)) {
                temp.add(prefix);
                partition(s.substring(i), temp, ret);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(palindromePartition("0204451881"));
    }
}
