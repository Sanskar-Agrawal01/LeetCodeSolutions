class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();
        for(String s : words){
            int sum = 0;
            for(char ch : s.toCharArray()){
                sum += weights[ch - 'a'];
            }
            int n = sum % 26;
            char ch = (char)('z' - n ) ;
            str.append(ch);
        }
        return str.toString();
    }
}