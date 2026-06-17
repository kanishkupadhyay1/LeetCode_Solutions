class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                len++;
            } else if (c == '*') {
                if (len > 0) len--;
            } else if (c == '#') {
                len *= 2;
            } else { // '%'
                // length unchanged
            }
        }

        if (k >= len) {
            return '.';
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                len--;

                if (k == len) {
                    return c;
                }
            }
            else if (c == '*') {
                len++;
            }
            else if (c == '#') {
                long prevLen = len / 2;

                if (k >= prevLen) {
                    k -= prevLen;
                }

                len = prevLen;
            }
            else { // '%'
                k = len - 1 - k;
            }
        }

        return '.';
    }
}