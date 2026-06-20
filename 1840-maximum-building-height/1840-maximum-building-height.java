class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int len = restrictions.length;
        if(len == 0) return n - 1; 
        int temp[][] = new int[len + 2][2];
        for(int i = 0;i<len;i++){
            temp[i] = restrictions[i];
        }
        temp[len] = new int [] {1, 0};
        temp[len + 1] = new int []{n, n -1};
        int max = 0;
        Arrays.sort(temp, (a,b) -> Integer.compare(a[0], b[0]));
        int m = temp.length;
        for(int i = 1; i < m; i++){
         int diff = temp[i][0] - temp[i-1][0];
         temp[i][1] = Math.min(temp[i][1], temp[i-1][1] + diff);
           
        }
        for(int i = m -2; i >= 0; i--){
         int diff = temp[i+ 1][0] - temp[i][0];
         temp[i][1] = Math.min(temp[i][1], temp[i+1][1] + diff);
        }  
        long ans = 0;
        for(int i = 1;i<m;i++){
            int dist = temp[i][0] - temp[i-1][0];
            int dist2 = Math.max(temp[i][1], temp[i-1][1]) + (dist - Math.abs(temp[i][1] - temp[i-1][1])) /2;
            ans = Math.max(ans, dist2);
        }
        return (int)ans;
    }
}