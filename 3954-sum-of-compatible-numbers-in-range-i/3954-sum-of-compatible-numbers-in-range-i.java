class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int idx = n - k;
        int end = n + k;
        int sum = 0;
        for (int i = 1; i <= end; i++) {
            if (Math.abs(n - i) <= k && (n & i) == 0) {
                sum += i;
            }
        }
        return sum;
    }
}