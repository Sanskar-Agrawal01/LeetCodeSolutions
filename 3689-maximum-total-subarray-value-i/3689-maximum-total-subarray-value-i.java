class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for(int n : nums){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        return k*(max - min);
    }
}