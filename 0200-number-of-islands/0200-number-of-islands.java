class Solution {
    public int numIslands(char[][] grid) {
        int vis[][] = new int[grid.length][grid[0].length];
        int cnt = 0;
        for(int i = 0;i<grid.length;i++){
          Arrays.fill(vis[i], -1);
        }
        
        for(int i = 0;i<grid.length;i++){
            for(int j = 0 ;j<grid[0].length;j++){
                if(vis[i][j] == -1 && grid[i][j] == '1'){
                    cnt++;
                    dfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }
    void dfs(int i , int j, int vis[][], char grid[][]){
        if(i < 0 || j < 0 || i >= grid.length || j>= grid[0].length) return;
        int dr[] = { 0, -1, 0, 1};
        int dc[] = {-1, 0, 1, 0};
        for(int x = 0;x <4;x++){
            int nr = dr[x] + i;
            int nc = dc[x] + j;
            if(nr >= 0 && nr < grid.length && nc >= 0  && nc < grid[0].length && vis[nr][nc] == -1 && grid[nr][nc] == '1'){
                vis[nr][nc] = '0';
                dfs(nr, nc, vis, grid);
            }
        }
    }
}