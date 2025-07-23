import java.util.*;

class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean recurse(String s, int index, int count) {
        if (count < 0) return false;
        if (index == s.length()) return count == 0;

       
        String key = index + "," + count;
        if (memo.containsKey(key)) return memo.get(key);

        boolean result;
        if (s.charAt(index) == '(') {
            result = recurse(s, index + 1, count + 1);
        } else if (s.charAt(index) == ')') {
            result = recurse(s, index + 1, count - 1);
        } else {
            boolean add = recurse(s, index + 1, count + 1);
            boolean sub = recurse(s, index + 1, count - 1);
            boolean none = recurse(s, index + 1, count);
            result = add || sub || none;
        }

        
        memo.put(key, result);
        return result;
    }

    public boolean checkValidString(String s) {
        return recurse(s, 0, 0);
    }
}
