class Solution {
    public int stoneGameII(int[] piles) {
       int n = piles.length;
       int dp[][] = new int[n][n];
       for(int d[] : dp){
        Arrays.fill(d, -1);
       }
       int pref[] = new int[n];
       pref[n-1] = piles[n-1];
       for(int i = n -2;i>=0;i--){
        pref[i] = pref[i+1] + piles[i];
       }
       int idx = 0;
       int m =1;
       return  recur(idx, m, piles, pref, dp, n);
        
    }
    public static int recur(int idx, int m, int[] piles, int pref[], int dp[][], int n){
        if(idx == n) return 0;
        if(2*m >= n - idx){
           return pref[idx];
        }
        if(dp[idx][m] != -1) return dp[idx][m];
        int ans = 0;
        for(int i = 1;i<=2*m;i++){
            int oppo = recur(idx + i, Math.max(m,i), piles, pref, dp, n);
            int alice = pref[idx] - oppo;
            ans = Math.max(ans, alice);
           
        }
        return  dp[idx][m] = ans;

    }
}