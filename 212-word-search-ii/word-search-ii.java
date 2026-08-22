class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        TrieNode root = new TrieNode();

        // Build Trie
        for (String word : words) {
            insert(root, word);
        }

        // DFS from every cell
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {

                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void insert(TrieNode root, String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    private void dfs(char[][] board,
                     int r,
                     int c,
                     TrieNode node,
                     List<String> result) {

        // Boundary / visited check
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length ||
            board[r][c] == '#') {

            return;
        }

        char ch = board[r][c];

        int index = ch - 'a';

        // Character doesn't exist in Trie
        if (node.children[index] == null) {
            return;
        }

        TrieNode next = node.children[index];

        // Found a complete word
        if (next.word != null) {

            result.add(next.word);

            // Prevent duplicate result
            next.word = null;
        }

        // Mark visited
        board[r][c] = '#';

        // Explore 4 directions
        dfs(board, r + 1, c, next, result);
        dfs(board, r - 1, c, next, result);
        dfs(board, r, c + 1, next, result);
        dfs(board, r, c - 1, next, result);

        // Backtrack
        board[r][c] = ch;
    }
}