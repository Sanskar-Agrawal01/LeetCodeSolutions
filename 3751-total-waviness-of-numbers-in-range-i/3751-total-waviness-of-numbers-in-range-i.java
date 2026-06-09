class Solution {
    public int totalWaviness(int num1, int num2) {
        int len = num2 - num1 + 1;
        int count = 0;
        int var = num1;
        for(int i = 0;i<len;i++){
              int cnt = helper(var);
              count = count + cnt;
              var++;
        }
        return count;
    }
    public static int helper(int num){
        int count = 0;
        String str = Integer.toString(num);
        for(int i = 1;i<str.length()-1;i++){
            int n1 = Integer.parseInt(String.valueOf(str.charAt(i-1)));
            int n2 = Integer.parseInt(String.valueOf(str.charAt(i)));
            int n3 = Integer.parseInt(String.valueOf(str.charAt(i + 1)));
            if(n2 > n1 && n2 > n3){
                count++;
            }
            if(n2 < n1 && n2 < n3){
                count++;
            }
        }
        return count;
    }
}
