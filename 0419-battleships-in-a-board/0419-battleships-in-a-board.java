class Solution {
    public int countBattleships(char[][] board) {
        int ans = 0;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 'X'){
                    ans++;
                    dfs(i, j, board);
                }
            }
        }
        return ans;

    }
    void dfs(int i, int j, char board[][]){
        board[i][j] = 'N';
        int dr [] = {0, -1, 0, 1};
        int dc [] = {-1, 0, 1, 0};
        for(int x = 0;x<4;x++){
            int nr = dr[x] + i;
            int nc = dc[x] + j;
            if( nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length  && board[nr][nc] == 'X'){
                dfs(nr, nc, board);
            }
        }
    }
}