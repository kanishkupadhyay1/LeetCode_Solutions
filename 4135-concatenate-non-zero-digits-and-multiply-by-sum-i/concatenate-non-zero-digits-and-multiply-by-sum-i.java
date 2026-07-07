class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);

        long num = 0;
        long sum = 0;

        for (char c : s.toCharArray()) {
            if (c != '0') {
                int digit = c - '0';
                num = num * 10 + digit;
                sum += digit;
            }
        }

        return num * sum;
    }
}