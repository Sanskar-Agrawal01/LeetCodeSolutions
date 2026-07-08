class Solution {
    static final int MOD = 1000000007;
    static final int MAX = 100001;
    static long[] pow = new long[MAX];
    static {
        pow[0] = 1;
        for (int i = 1; i < MAX; i++) {
            pow[i] = (pow[i - 1] * 10) % MOD;
        }
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] A = new long[n + 1];   
        long[] B = new long[n + 1];   
        int[] Len = new int[n + 1];   
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            A[i + 1] = A[i] + d;
            if (d != 0)
                B[i + 1] = (B[i] * 10 + d) % MOD;
            else
                B[i + 1] = B[i];
            Len[i + 1] = Len[i] + (d != 0 ? 1 : 0);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            long sub = (B[l] * pow[Len[r] - Len[l]]) % MOD;
            long x = (B[r] - sub + MOD) % MOD;
            long sum = A[r] - A[l];
            ans[i] = (int) ((x * sum) % MOD);
        }
        return ans;
    }
}