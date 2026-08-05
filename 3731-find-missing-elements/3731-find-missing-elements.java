class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
            res.add(n);
        }
        for(int i = min;i<=max;i++){
           if(!res.contains(i))res2.add(i);
        }
        
        return res2;
    }
}