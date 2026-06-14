class Solution {
    public boolean checkGoodInteger(int n) {
        int sum =0;
        int sqSum = 0;
        while( n > 0){
            int num = n % 10;
            sum += num;
            sqSum += num*num;
            n = n /10;
        }
        return sqSum - sum >= 50;
    }
}