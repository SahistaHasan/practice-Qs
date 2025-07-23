import java.util.*;

class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean recurse(String s, int index, int count) {
        if (count < 0) return false;
        if (index == s.length()) return count == 0;

        String key = index + "," + count;
        if (memo.containsKey(key)) return memo.get(key);

        char ch = s.charAt(index);
        boolean result;

        if (ch == '(') {
            result = recurse(s, index + 1, count + 1);
        } else if (ch == ')') {
            result = recurse(s, index + 1, count - 1);
        } else { // '*'
            result = recurse(s, index + 1, count + 1) ||   // as '('
                     recurse(s, index + 1, count - 1) ||   // as ')'
                     recurse(s, index + 1, count);         // as empty
        }

        memo.put(key, result);
        return result;
    }

    public boolean checkValidString(String s) {
        return recurse(s, 0, 0);
    }
}
