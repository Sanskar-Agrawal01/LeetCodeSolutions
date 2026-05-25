class Solution {
    public int minOperations(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            int x = i;
            for (int j = 0; j < k; j++) {
                int y = j;
                int cnt = 0;
                if (x == y)
                    continue;
                for (int h = 0; h < nums.length; h++) {
                    int n = nums[h];
                    int let = n % k;
                    if (h % 2 == 0) {
                        cnt += Math.min(Math.abs(let - x), k - Math.abs(let - x));
                    } else {
                        cnt += Math.min(Math.abs(let - y), k - Math.abs(let - y));
                    }
                }
                min = Math.min(min, cnt);
            }
        }
        return min;
    }
}