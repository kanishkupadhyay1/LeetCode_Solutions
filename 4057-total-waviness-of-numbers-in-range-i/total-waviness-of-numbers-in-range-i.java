class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int x = num1; x <= num2; x++) {
            char[] s = String.valueOf(x).toCharArray();

            for (int i = 1; i < s.length - 1; i++) {
                if ((s[i] > s[i - 1] && s[i] > s[i + 1]) ||
                    (s[i] < s[i - 1] && s[i] < s[i + 1])) {
                    ans++;
                }
            }
        }

        return ans;
    }
}