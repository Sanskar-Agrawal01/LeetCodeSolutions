class Solution {
    public int gcdOfOddEvenSums(int n) {
        int even = n*(n+1);
        int odd = n*n;
        return gcd(odd, even);

    }
     private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}