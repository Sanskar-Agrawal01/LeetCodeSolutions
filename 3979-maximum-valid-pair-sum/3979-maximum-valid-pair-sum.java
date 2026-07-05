class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int ans = 0;
        int pref [] = new int[nums.length];
        pref[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2;i>=0;i--){
            pref[i] = Math.max(pref[i+1], nums[i]);
        }
        for(int i = 0;i<nums.length - k;i++){
           ans = Math.max(ans, nums[i] + pref[i + k]);
        }        
        return ans;
    }
}