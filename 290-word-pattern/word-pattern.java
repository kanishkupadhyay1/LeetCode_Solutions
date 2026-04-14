class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        
        if (pattern.length() != arr.length) return false;

        int[] pat = new int[256];
        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            String w = arr[i];

            if (pat[c] != mp.getOrDefault(w, 0)) return false;

            pat[c] = i + 1;
            mp.put(w, i + 1);
        }

        return true; 
    }
}