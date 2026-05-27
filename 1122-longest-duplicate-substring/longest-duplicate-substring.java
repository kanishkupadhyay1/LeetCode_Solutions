import java.util.*;

class Solution {

    public String longestDupSubstring(String s) {

        int low = 1;
        int high = s.length() - 1;

        int start = -1;
        int maxLen = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int idx = search(s, mid);

            if (idx != -1) {
                start = idx;
                maxLen = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return start == -1 ? "" : s.substring(start, start + maxLen);
    }

    private int search(String s, int len) {

        long mod = 1000000007L;
        long base = 31;

        long hash = 0;
        long power = 1;

        for (int i = 0; i < len; i++) {

            hash = (hash * base + (s.charAt(i) - 'a' + 1)) % mod;

            if (i < len - 1) {
                power = (power * base) % mod;
            }
        }

        Map<Long, List<Integer>> map = new HashMap<>();

        map.putIfAbsent(hash, new ArrayList<>());
        map.get(hash).add(0);

        for (int i = len; i < s.length(); i++) {

            hash = (hash -
                   ((s.charAt(i - len) - 'a' + 1) * power) % mod
                   + mod) % mod;

            hash = (hash * base +
                   (s.charAt(i) - 'a' + 1)) % mod;

            int start = i - len + 1;

            if (map.containsKey(hash)) {

                String curr = s.substring(start, start + len);

                for (int prev : map.get(hash)) {

                    if (s.substring(prev, prev + len).equals(curr)) {
                        return start;
                    }
                }
            }

            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(start);
        }

        return -1;
    }
}