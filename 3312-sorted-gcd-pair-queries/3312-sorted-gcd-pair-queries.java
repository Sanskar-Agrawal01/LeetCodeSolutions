class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);

        int[] mp = new int[mx + 1];
        for (int x : nums) mp[x]++;

        long[] cnt = new long[mx + 1];

        for (int i = mx; i >= 1; i--) {
            long cur = 0;
            for (int j = i; j <= mx; j += i) cur += mp[j];
            cnt[i] = cur * (cur - 1) / 2;
            for (int j = i * 2; j <= mx; j += i) cnt[i] -= cnt[j];
        }

        for (int i = 1; i <= mx; i++) cnt[i] += cnt[i - 1];

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) ans[i] = lb(cnt, queries[i] + 1);
        return ans;
    }

    int lb(long[] a, long x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] >= x) r = m;
            else l = m + 1;
        }
        return l;
    }
}