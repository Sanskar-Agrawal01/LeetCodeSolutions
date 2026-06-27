class Solution {
    public boolean areNumbersAscending(String s) {
        String num[] = s.split(" ");
        int temp = Integer.MIN_VALUE;
        int n = Integer.MIN_VALUE;
        for(String str : num){
            if(Character.isDigit(str.charAt(0))){
                 n = Integer.parseInt(str);
                 if(n <= temp) return false;
                 else temp = n;
            }                
            } 
            return true;        
        }
}