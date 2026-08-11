class Solution {
    public int missingInteger(int[] nums) {
        // int pref[] = new int[nums.length];
        // pref[0] = nums[0];
        // for(int i = 1;i<nums.length;i++){
        //     pref[i]  = pref[i-1] + nums[i];
        // }
        int se = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == nums[i-1] + 1){
                se += nums[i];
            }
            else{
                break;
            }
        }
        Set<Integer> list = new HashSet<>();
        for(int n : nums) list.add(n);
        if(!list.contains(se)) return se;
        while(list.contains(se)){
                se = se+1;
            } 
            
        return se;      
    }
}