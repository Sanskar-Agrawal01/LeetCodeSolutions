class Solution {
    public boolean consecutiveSetBits(int n) {
        String s = Integer.toBinaryString(n);
        int cnt = 0;
        for(int i = 0;i<s.length() - 1;i++){
            if(s.charAt(i) == s.charAt(i+1) && s.charAt(i) == '1') cnt++;
        }
        return cnt == 1;
    }
}