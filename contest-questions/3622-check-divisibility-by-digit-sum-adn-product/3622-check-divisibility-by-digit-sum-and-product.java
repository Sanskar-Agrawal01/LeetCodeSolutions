class Solution {
    public static int dsum(int n ){
        int sum = 0;
        while(n>0){
           sum  = sum + (n % 10);
           n = n /10;
        }
        return sum;
    }
    public static int dmul(int n ){
        int mul = 1;
        while(n > 0){
            mul = mul * (n % 10);
            n = n /10;
        }
        return mul;
    }
    public boolean checkDivisibility(int n) {
        int sum  = dsum(n) + dmul(n);
        return n % sum == 0;
    }
}