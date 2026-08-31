class Solution {

    public int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);

        // If endWord is not available, impossible
        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);

        // Begin word counts as level 1
        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                char[] chars = word.toCharArray();

                // Change each character
                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) {
                            continue;
                        }

                        chars[j] = ch;

                        String next =
                            new String(chars);

                        // Found target
                        if (next.equals(endWord)) {
                            return level + 1;
                        }

                        // Valid and not visited
                        if (words.contains(next)) {

                            queue.offer(next);

                            // Mark visited
                            words.remove(next);
                        }
                    }

                    // Restore character
                    chars[j] = original;
                }
            }

            level++;
        }

        return 0;
    }
}