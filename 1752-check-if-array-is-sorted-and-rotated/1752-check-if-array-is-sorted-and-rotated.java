class Solution {
    public boolean check(int[] nums) {
       int n = nums.length;
       int cnt = 0;
       for(int i =1;i<n;i++){
        if(nums[i-1] > nums[i]) cnt++;
       }
       return cnt == 0 || (cnt == 1 && nums[n -1] <= nums[0]);
    }
}