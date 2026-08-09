class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
         int n = nums.length;
         recur(nums, 0, result, n);
         return result;
    }
    public static void recur(int [] nums, int idx,  List<List<Integer>> result, int n){
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