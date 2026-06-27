class Solution {
    public int maximumLength(int[] nums) {
        Arrays.sort(nums);
        Map<Long, Integer> map = new HashMap<>();
        int cnt = 1;
        for (int n : nums) {
            map.put((long)n, map.getOrDefault((long)n, 0) + 1);
        }
        if (map.containsKey(1L)) {
            int temp = map.get(1L);
            cnt = Math.max(cnt, (temp % 2 == 0) ? temp - 1 : temp);
        }
        for (long num : map.keySet()) {
            if(num == 1) continue;
            long curr = num;
            int len = 0;
            while (true) {
                if (!map.containsKey(curr)) {
                    len = len - 1;
                    break;
                }

                if (map.get(curr) >= 2)
                    len += 2;
                else {
                    len += 1;
                    break;
                }

                if (curr > (long)Math.sqrt(Long.MAX_VALUE))
                    break;

                curr = curr * curr;
            }
            cnt = Math.max(cnt, len);
        }
        return cnt;
    }
}