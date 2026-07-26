class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3) return -1;
        int p1 = nums[0]*nums[1]*nums[nums.length - 1];
        return p1 > nums[nums.length  - 1]*nums[nums.length - 2]*nums[nums.length - 3] ? p1 :  nums[nums.length  - 1]*nums[nums.length - 2]*nums[nums.length - 3];
    }
}