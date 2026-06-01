class Solution {
    public int digitFrequencyScore(int n) {
        int freq[] = new int[10];
        String s = Integer.toString(n);
        for(char ch : s.toCharArray()){
            freq[ch - '0']++;
        }
        int ans = 0;
        for(int i = 0;i<freq.length;i++){
            ans+= freq[i]*i;
        }
        return ans;
    }
}