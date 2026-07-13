class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int n = Integer.toString(low).length();
        int m = Integer.toString(high).length();
        String s = "123456789";
        for (int len = n; len <= m; len++) {
            for (int i = 0; i + len <= 9; i++) {
                int num = Integer.parseInt(s.substring(i, i + len));

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}