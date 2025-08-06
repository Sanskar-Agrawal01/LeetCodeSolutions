class Solution {
    static class Pair{
        int row;
        int col;
        int time;
        public Pair(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[grid.length][grid[0].length];
        int count = 0;
        for(int  i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                else {
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    count++;
                }           
            }
        }
        int tm = 0;
        int [] drow = {-1, 0, 1, 0};
        int [] dcol = {0, 1,0,-1};
        int count2 = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
           int t = q.peek().time;
           tm = Math.max(t,tm);
           q.remove();
           for(int i =0;i<4;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow>= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                q.add(new Pair(nrow, ncol, t + 1));
                vis[nrow][ncol] = 2;
                count2++;
            }
           }
        }
        if(count2 != count){
            return -1;
        }
        return tm;
    }
}