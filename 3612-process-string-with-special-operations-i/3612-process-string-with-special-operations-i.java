class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '*' && sb.length() > 0){
                sb.deleteCharAt(sb.length() -1);
            }
            else if(ch =='#'){
                sb.append(sb);
            }
            else if(ch == '%'){
             sb = sb.reverse();
            }
            else if(Character.isUpperCase(ch) || Character.isLowerCase(ch)){
            sb.append(ch);
            }
        }
        return sb.toString();
    }
}