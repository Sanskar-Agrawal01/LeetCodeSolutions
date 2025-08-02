class Solution {
    public int minRemoval(int[] nums, int k) {
         if (nums.length <= 1) {
            return 0;
        }      
        Arrays.sort(nums);
        int n = nums.length;
        int maxLen = 0; 
        int left = 0;         
        for (int right = 0; right < n; right++) {           
            while (nums[right] >(long)nums[left] * k) { 
                left++;
            }         
            maxLen = Math.max(maxLen, right - left + 1);
        }      
        return n - maxLen;
    }
}