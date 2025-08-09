class Solution {
    public static int mcm(int[] nums, int i, int j, int[][] dp) {
        if (j - i < 2) return 0; 

        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int cost1 = mcm(nums, i, k, dp);
            int cost2 = mcm(nums, k, j, dp);
            int cost3 = nums[i] * nums[k] * nums[j];

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

      
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        return mcm(values, 0, n - 1, dp);
    }
}