import java.util.*;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // directions for each type
        int[][][] dirs = {
            {}, // 0 (unused)
            {{0, -1}, {0, 1}},   // 1
            {{-1, 0}, {1, 0}},   // 2
            {{0, -1}, {1, 0}},   // 3
            {{0, 1}, {1, 0}},    // 4
            {{0, -1}, {-1, 0}},  // 5
            {{0, 1}, {-1, 0}}    // 6
        };

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            if (x == m - 1 && y == n - 1) return true;

            for (int[] d : dirs[grid[x][y]]) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny])
                    continue;

                // check reverse connection
                for (int[] back : dirs[grid[nx][ny]]) {
                    if (nx + back[0] == x && ny + back[1] == y) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        break;
                    }
                }
            }
        }

        return false;
    }
}