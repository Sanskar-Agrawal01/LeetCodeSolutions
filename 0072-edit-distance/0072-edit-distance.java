class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n == 0 && m == 0) return 0;
        int dp[][] = new int[m +1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            char ch1 = word2.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char ch2 = word1.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j  - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i-1][j-1], dp[i][j - 1])) + 1;
                }

            }
        }
        return dp[m][n];
    }
}