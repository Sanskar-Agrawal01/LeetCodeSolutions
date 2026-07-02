class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[][] dirs = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));
        dist[0][0] = grid.get(0).get(0);
        pq.offer(new int[] { dist[0][0], 0, 0 });
        while (!pq.isEmpty()) {
            int curr[] = pq.remove();
            int d = curr[0];
            int r = curr[1];
            int c = curr[2];
            if (d > dist[r][c])
                continue;
            for (int dir[] : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }

                int newdist = d + grid.get(nr).get(nc);
                if (newdist < dist[nr][nc]) {

                    dist[nr][nc] = newdist;

                    pq.offer(new int[] {
                            newdist,
                            nr,
                            nc
                    });
                }
            }
        }
        if(dist[m-1][n-1] < health) return true;
        return false;
    }
}