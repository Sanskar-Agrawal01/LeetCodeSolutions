class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length == 1 || nums.length == 2) return nums.length;
        return (int)Math.pow(2, Integer.toBinaryString(nums.length).length());
    }
}