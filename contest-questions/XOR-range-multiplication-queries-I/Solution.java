class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int MOD = 1000000007;
        for(int [] q: queries){
            int left = q[0];
            int right = q[1];
            int k = q[2];
            int val = q[3];

            for(int i = left;i<=right;i+=k){
                nums[i] = (int)((1L * nums[i] * val) % MOD);
            }
        }
        int x = nums[0];
        for(int i  = 0;i<nums.length -1;i++){
            
            x = x ^ nums[i+1];
        }
        return x;
    }
}