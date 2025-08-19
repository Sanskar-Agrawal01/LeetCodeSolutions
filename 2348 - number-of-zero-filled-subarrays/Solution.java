class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count1 = 0;
        long count2 = 0;
        for(int n : nums){
            if(n == 0){
                count1 += 1;
                count2 += count1;        
            }else{
                count1 = 0;
            }
        }
        return count2;
    }
}