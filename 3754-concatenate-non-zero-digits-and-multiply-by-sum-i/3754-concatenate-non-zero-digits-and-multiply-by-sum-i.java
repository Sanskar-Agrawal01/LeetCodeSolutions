class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        long sum = 0;
        while(n > 0){
            int num = n % 10;
            if(num != 0){
                sum += num;
                ans = ans*10 + num;
            }
            n = n / 10;
        }
        long res = 0;
        while(ans > 0){
             res = res*10 + (ans % 10);
             ans = ans/10;
        }
        return res*sum;
    }
}