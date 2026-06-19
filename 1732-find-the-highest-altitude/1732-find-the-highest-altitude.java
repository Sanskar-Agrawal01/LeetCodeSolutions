class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int max = 0;
        for(int n: gain){
           ans+=n;
           max= Math.max(max, ans);   
        }
        return max;
    }
}