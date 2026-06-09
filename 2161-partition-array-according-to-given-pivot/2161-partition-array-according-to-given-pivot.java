class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> great = new ArrayList<>();
        int cnt = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] < pivot) less.add(nums[i]);
            else if(nums[i] == pivot) cnt++;
            else great.add(nums[i]);
        }
        int ans[] = new int[nums.length];
        int idx = 0;
        for(int i = 0;i<less.size();i++){
            ans[idx] = less.get(i);
            idx++;
        }
        for(int  i =0;i<cnt;i++){
            ans[idx] = pivot;
            idx++;
        }
        for(int i = 0;i<great.size();i++){
            ans[idx] = great.get(i);
            idx++;
        }
        return ans;
    }
}