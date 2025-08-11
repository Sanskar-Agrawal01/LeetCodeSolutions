class Solution {
    public int sortPermutation(int[] nums) {
       int ms = Integer.MAX_VALUE;
       for(int i = 0;i<nums.length;i++){
        if(nums[i] != i){
            ms = ms & nums[i];
        }
       } 
       if(ms == Integer.MAX_VALUE){
        return 0;
       }
       return ms;
    }
}