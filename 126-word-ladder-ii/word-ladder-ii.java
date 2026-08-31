class Solution {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return result;
        }

        // word -> all previous words
        Map<String, List<String>> parents = new HashMap<>();

        // word -> shortest distance from beginWord
        Map<String, Integer> distance = new HashMap<>();

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        distance.put(beginWord, 0);

        boolean found = false;

        // -------------------------
        // BFS
        // -------------------------

        while (!queue.isEmpty() && !found) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                int currentDist = distance.get(word);

                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) {
                            continue;
                        }

                        chars[j] = ch;

                        String next = new String(chars);

                        if (!words.contains(next)) {
                            continue;
                        }

                        // First time discovering next
                        if (!distance.containsKey(next)) {

                            distance.put(
                                next,
                                currentDist + 1
                            );

                            queue.offer(next);

                            parents
                                .computeIfAbsent(
                                    next,
                                    k -> new ArrayList<>()
                                )
                                .add(word);

                        }

                        // Another shortest path
                        else if (distance.get(next)
                                 == currentDist + 1) {

                            parents
                                .computeIfAbsent(
                                    next,
                                    k -> new ArrayList<>()
                                )
                                .add(word);
                        }

                        if (next.equals(endWord)) {
                            found = true;
                        }
                    }

                    chars[j] = original;
                }
            }
        }

        // -------------------------
        // DFS
        // -------------------------

        if (!distance.containsKey(endWord)) {
            return result;
        }

        List<String> path = new ArrayList<>();

        path.add(endWord);

        dfs(
            endWord,
            beginWord,
            parents,
            path,
            result
        );

        return result;
    }

    private void dfs(
            String current,
            String beginWord,
            Map<String, List<String>> parents,
            List<String> path,
            List<List<String>> result) {

        // Reached beginning
        if (current.equals(beginWord)) {

            List<String> completePath =
                new ArrayList<>(path);

            Collections.reverse(completePath);

            result.add(completePath);

            return;
        }

        if (!parents.containsKey(current)) {
            return;
        }

        for (String parent : parents.get(current)) {

            path.add(parent);

            dfs(
                parent,
                beginWord,
                parents,
                path,
                result
            );

            // Backtrack
            path.remove(path.size() - 1);
        }
    }
}