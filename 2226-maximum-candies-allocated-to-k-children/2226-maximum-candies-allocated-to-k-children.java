class Solution {
    public int maximumCandies(int[] candies, long k) {
        long low = 1;
        long high = 0;
        for(int n : candies) high =  Math.max(n, high);
        long ans = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            long cnt = 0;
            for(int num : candies){
                cnt += num / mid;
            }
            if( cnt >= k){
                ans = mid;
                low = mid  + 1;
            }
            else{
               high  = mid - 1;
            }
        }
        return (int)ans;
    }
}