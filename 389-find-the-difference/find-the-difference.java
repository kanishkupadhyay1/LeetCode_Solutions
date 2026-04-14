class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();

        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (mp.getOrDefault(ch, 0) == 0) return ch;
            mp.put(ch, mp.get(ch) - 1);
        }

        return ' '; 
    }
}