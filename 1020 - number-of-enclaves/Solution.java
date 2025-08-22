class Solution {
    public static void dfs(int a, int b, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

         if (a < 0 || b < 0 || a >= n || b >= m || grid[a][b] != 1) return;

        grid[a][b] = 0;
        int rd [] = {-1,0,1,0};
        int cd [] = {0,1,0,-1};
        for(int i = 0;i<4;i++){
            int row =a+ rd[i];
            int col =b + cd[i];
            dfs(row, col, grid);
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i= 0;i<n;i++){
            if(grid[i][0] == 1){
                dfs(i,0, grid);
            }
            if(grid[i][m - 1] == 1){
                dfs(i,m-1, grid);
            }
        }
        for(int i= 0;i<m;i++){
            if(grid[0][i] == 1){
                dfs(0, i, grid);
            }
            if(grid[n-1][i] == 1){
                dfs(n-1, i, grid);
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                   count++;
                }
                
            }
        }
        return count;
    }
}