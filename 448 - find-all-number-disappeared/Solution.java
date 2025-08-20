class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            mp.put(i, 0);
        }

        for (int a : nums) {
            mp.put(a, mp.get(a) + 1);
        }

        

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 0) {
               list.add(entry.getKey());
            }
        }
      return list;
    }
}