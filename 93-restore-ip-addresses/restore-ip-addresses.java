class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        backtrack(s, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(String s,
                            int index,
                            int parts,
                            StringBuilder current,
                            List<String> result) {

        if (parts == 4) {

            if (index == s.length()) {
                result.add(current.toString());
            }

            return;
        }

        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            if (Integer.parseInt(part) > 255) {
                break;
            }

            int oldLength = current.length();

            if (parts > 0) {
                current.append(".");
            }

            current.append(part);

            backtrack(
                s,
                index + len,
                parts + 1,
                current,
                result
            );

            current.setLength(oldLength);
        }
    }
}