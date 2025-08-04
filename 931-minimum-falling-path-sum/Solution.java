class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int j =0;j<matrix[0].length;j++){
            dp[0][j] = matrix[0][j];
        }
        
        for(int i = 1;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(j == 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];
                } else if (j == matrix[0].length - 1) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + matrix[i][j];
                } else {
                dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1])) + matrix[i][j];
               
            }
        }
    }
    int ans= Integer.MAX_VALUE;
    for(int j = 0;j<matrix[0].length;j++){
        ans = Math.min(ans, dp[matrix.length-1][j]);
    }
    return ans;
    }
    public static void main(String[] args) {
        int matrix[][] = {{2,1,3},{6,5,4},{7,8,9}};
        Solution sol = new Solution();  
        int result = sol.minFallingPathSum(matrix);
        System.out.println("Minimum Falling Path Sum: " + result); 
    }
}