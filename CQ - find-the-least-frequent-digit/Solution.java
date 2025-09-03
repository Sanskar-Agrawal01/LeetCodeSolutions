class Solution {
    public int getLeastFrequentDigit(int n) {
          String str = Integer.toString(n);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        int ans = -1;     
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int digit = entry.getKey();
            int freq = entry.getValue();

            if (freq < min || (freq == min && digit < ans)) {
                min = freq;
                ans = digit;
            }
        }

        return ans;
    }
}