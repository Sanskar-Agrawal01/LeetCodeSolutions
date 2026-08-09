class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
         Set<List<Integer>> result = new HashSet<>();
         int n = nums.length;
         recur(nums, 0, result, n);
         List<List<Integer>> res = new ArrayList<>();
         for(List<Integer> list : result){
            res.add(list);
         }
         return res;
    }
    public static void recur(int [] nums, int idx,  Set<List<Integer>> result, int n){
        if(idx == n){
            List<Integer> list = new ArrayList<>();
            for(int x : nums)list.add(x);
            result.add(list);
            return;
        }
        for(int i = idx;i<n;i++){
            swap(nums, idx, i);
            recur(nums, idx + 1, result, n);
            swap(nums, idx, i);

        }
    }
    public static void swap(int nums[] , int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}