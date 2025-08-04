class Solution {
     public static int rob2(int nums[], int start, int end, int dp[]) {
        dp[start] = nums[start];
        if (start + 1 <= end) {
            dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        }

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[end];
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int dp1[] = new int[nums.length];  
        int dp2[] = new int[nums.length]; 

        return Math.max(rob2(nums, 0, nums.length - 2, dp1), rob2(nums, 1, nums.length - 1, dp2));
    }
}
