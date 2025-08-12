class Solution {
    public static void dfs(int a, int b, char[][] board){
        int n = board.length;
        int m = board[0].length;

         if (a < 0 || b < 0 || a >= n || b >= m || board[a][b] != 'O') return;

        board[a][b] = '#';
        int rd [] = {-1,0,1,0};
        int cd [] = {0,1,0,-1};
        for(int i = 0;i<4;i++){
            int row =a+ rd[i];
            int col =b + cd[i];
            dfs(row, col, board);
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);      
            if (board[i][m - 1] == 'O') dfs(i, m - 1, board);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(0, j, board);       
            if (board[n - 1][j] == 'O') dfs(n - 1, j, board); 
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }
}