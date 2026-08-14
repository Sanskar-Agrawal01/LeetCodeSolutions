class Solution {
    public int maximumLengthSubstring(String nums) {
       HashMap<Character, Integer> freq = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length(); right++) {
            freq.put(nums.charAt(right), freq.getOrDefault(nums.charAt(right), 0) + 1);

            while (freq.get(nums.charAt(right)) > 2) {
                freq.put(nums.charAt(left), freq.get(nums.charAt(left)) - 1);
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}