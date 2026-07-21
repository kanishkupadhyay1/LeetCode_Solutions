class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int ones = 0;
        int prevZero = Integer.MIN_VALUE;
        int bestMerge = 0;

        int i = 0;
        int n = s.length();

        while (i < n) {

            int j = i;

            while (j < n && s.charAt(j) == s.charAt(i))
                j++;

            int len = j - i;

            if (s.charAt(i) == '1') {
                ones += len;
            } else {
                bestMerge = Math.max(bestMerge, prevZero + len);
                prevZero = len;
            }

            i = j;
        }

        return ones + bestMerge;
    }
}