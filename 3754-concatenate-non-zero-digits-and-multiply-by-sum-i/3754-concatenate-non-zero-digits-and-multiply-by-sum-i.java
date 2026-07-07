class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        long sum = 0;
        String s = Integer.toString(n);
        for(char ch : s.toCharArray()){
            if(ch - '0' > 0){
                ans = ans*10 + (ch -'0');
                sum+=(ch - '0');
            }
        }
        return ans*sum;
    }
}