class Solution {
    static final int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] dp = new long[m][n];
        dp[0][0] = 1;
      for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long ways = dp[i][j];
                if (ways == 0)
                    continue;

                if (j + 1 < n) {
                    reflectAndAdd(i, j + 1, ways, grid, dp, m, n, true);
                }

                if (i + 1 < m) {
                    reflectAndAdd(i + 1, j, ways, grid, dp, m, n, false);
                }
            }
        }

        return (int) (dp[m - 1][n - 1] % MOD);
    }
    private void reflectAndAdd(int i, int j, long ways, int[][] grid, long[][] dp,
            int m, int n, boolean fromLeft) {
        while (true) {
            if (i >= m || j >= n)
                return;

            if (grid[i][j] == 0) {
                dp[i][j] = (dp[i][j] + ways) % MOD;
                return;
            }

            if (fromLeft) {
                i++;
                fromLeft = false;
            } else {
                j++;
                fromLeft = true;
            }
        }
    }
}
