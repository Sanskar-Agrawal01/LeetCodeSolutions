class Solution {
    public int maxProduct(int n) {
        int n1 = 0 ,n2 = 0;
        for(char ch : (Integer.toString(n)).toCharArray()){
            if(ch - '0' > n1){
                n2 = n1;
                n1 = ch - '0';
            }
            else if((ch - '0') > n2){
                n2  = ch - '0';
            }
        }
        return n1*n2;
    }
}