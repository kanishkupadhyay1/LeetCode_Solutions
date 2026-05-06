class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z ]", " ");

        Set<String> bannedSet = new HashSet<>();

        for (String word : banned) {
            bannedSet.add(word);
        }

        Map<String, Integer> map = new HashMap<>();

        String[] words = paragraph.split("\\s+");

        for (String word : words) {

            if (!bannedSet.contains(word) && !word.equals("")) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        String result = "";
        int max = 0;

        for (String word : map.keySet()) {

            if (map.get(word) > max) {
                max = map.get(word);
                result = word;
            }
        }

        return result;
    }
}