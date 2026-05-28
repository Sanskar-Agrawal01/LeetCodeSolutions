class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft[] = new int[n];
        int maxRight[] = new int[n];
        int diff[] = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = height[i];
            max = Math.max(max, temp);
            maxLeft[i] = max;
        }
        int maxR = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxR = Math.max(maxR, height[i]);
            maxRight[i] = maxR;
        }
        int min = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(maxLeft[i], maxRight[i]);
            diff[i] = min;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(diff[i] - height[i]);
        }
        return ans;
    }
}