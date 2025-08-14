class Solution {
    public String largestGoodInteger(String num) {
        ArrayList<Character> set = new ArrayList<>();
        char arr[] = num.toCharArray();
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] && arr[i] == arr[i - 2]) {
                set.add(arr[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<set.size();i++){
          int n = Character.getNumericValue(set.get(i)); 
          if(n > max){
            max = n;
          }
        }
        
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<3;i++){
          str.append(Integer.toString(max));
        }
       if(max == Integer.MIN_VALUE){
        return "";
       }
       return   str.toString();
    }
}