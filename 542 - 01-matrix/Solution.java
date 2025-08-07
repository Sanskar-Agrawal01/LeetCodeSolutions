class Solution {
    static class Pair {
        int row;
        int col;
        int dist;
        public Pair(int r, int c, int d) {
            this.row = r;
            this.col = c;
            this.dist = d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[][] ans = new int[n][m];        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int d = p.dist;
            ans[r][c] = d;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0) {
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr, nc, d + 1));
                }
            }
        }
        return ans;
    }
}