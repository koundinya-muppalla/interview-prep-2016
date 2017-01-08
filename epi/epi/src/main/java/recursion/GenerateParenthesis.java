package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        if(n <= 0) {
            return ret;
        }
        generateParenthesis(n, "", 0, 0, ret);
        return ret;
    }

    private static void generateParenthesis(int n, String prefix, int left, int right, List<String> ret) {
        if(prefix.length() == 2*n) {
            if(left == right) {
                ret.add(prefix);
            }
            return;
        }

        if(left < n) {
            generateParenthesis(n, prefix + "(", left + 1, right, ret);
        }

        if(right < left) {
            generateParenthesis(n, prefix + ")", left, right + 1, ret);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
