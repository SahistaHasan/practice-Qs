

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 1, max = 1;
        int start = 0, end = 0;

        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        map.put(s.charAt(0), 1);

        while (end < s.length() - 1) {
            end++;
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            len++;

            while (map.get(s.charAt(end)) > 1) { // If duplicate found, shrink window
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
                len--;
            }

            max = Math.max(max, len);
        }

        return max;
    }
}
