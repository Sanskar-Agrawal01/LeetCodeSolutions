class Solution {
    public static int recur(String text1, String text2,int n, int m,int dp[][] ){
       if(n == 0 || m == 0){
        return 0;
       }
       if(dp[n][m]!=-1){
        return dp[n][m];
       }
       if(text1.charAt(n -1) == text2.charAt(m -1)){
        return dp[n][m] = recur(text1,text2,n-1,m-1,dp)+1;
       }
       else{
        int ans1 = recur(text1,text2,n-1,m,dp);
        int ans2 = recur(text1,text2,n,m-1,dp);
        return dp[n][m] = Math.max(ans1,ans2);
       }
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return recur(text1,text2,n,m,dp);
    }
}