class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int sr=0;
        int sc = 0;
        int er = matrix.length - 1;
        int ec = matrix[0].length - 1;
        while(sr <= er && sc <= ec){
            for(int j = sc;j <= ec;j++){
                res.add(matrix[sr][j]);
            }
            for(int i = sr+1;i<=er;i++){
                res.add(matrix[i][ec]);
            }
            for(int j = ec-1;j>=sc;j--){
                if(sr == er){
                    break;
                }
                res.add(matrix[er][j]);
            }
            for(int i = er -1;i>=sr+1;i--){
                if(sc == ec){
                    break;
                }
                res.add(matrix[i][sr]);
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
        return res;
    }
}
end