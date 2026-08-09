class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int max=  0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    max = Math.max(dfs(i, j, grid, vis), max);
                }
            }
        }
        return max;
    }
    public static int dfs(int r, int c, int [][]grid, boolean[][] vis){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || vis[r][c] == true || grid[r][c] != 1){
            return 0;
        }
        vis[r][c] = true;
        int area = 1;
        int rs[] = {1, 0, -1, 0};
        int cs [] = {0, 1, 0, -1};
        for(int i = 0;i<4;i++){
            int rw = r + rs[i];
            int cw = c + cs[i];
           
                area+=dfs(rw, cw, grid, vis);

            
        }
        return area;
    }
}