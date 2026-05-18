class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int curr = q.poll();

                if (curr == n - 1)
                    return steps;

                for (int next : map.get(arr[curr])) {

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }

                map.get(arr[curr]).clear();

                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    q.offer(curr + 1);
                }

                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    q.offer(curr - 1);
                }
            }

            steps++;
        }

        return -1;
    }
}