class Solution {
    public int countCharacters(String[] words, String chars) {

        int ans = 0;

        int[] baseFreq = new int[26];

        for (char ch : chars.toCharArray()) {
            baseFreq[ch - 'a']++;
        }

        for (String word : words) {

            int[] freq = new int[26];

            boolean possible = true;

            for (char ch : word.toCharArray()) {

                freq[ch - 'a']++;

                if (freq[ch - 'a'] > baseFreq[ch - 'a']) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                ans += word.length();
            }
        }

        return ans;
    }
}