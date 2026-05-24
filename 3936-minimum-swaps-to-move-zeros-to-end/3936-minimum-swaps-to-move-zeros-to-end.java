class Solution {
    public int minimumSwaps(int[] nums) {
        int cnt = 0;
        for(int n : nums){
            if(n == 0) cnt++;
        }
        for(int i = nums.length - cnt;i<nums.length;i++){
            if(nums[i]  == 0)cnt--;

        }
        return cnt;
    }
}