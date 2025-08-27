class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max = 0;
        int ans = 0;
        for(int  [] dm : dimensions){
            int l = dm[0];
            int b = dm[1];
            double d = Math.sqrt(l*l + b*b);
            int ar = l * b; 
            if( d > max){
                max = d;
                ans = ar;
            }
            else if(max == d){
                ans = Math.max(ans, ar);
            }
        }
        return ans;
    }
}