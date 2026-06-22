class Solution {
    public int maxNumberOfBalloons(String text) {
        int a = 0;
        int b = 0;
        int l = 0;
        int n = 0;
        int o = 0;
        for(int i = 0;i<text.length();i++){
            char ch = text.charAt(i);
            if(ch == 'b')b++;
            if(ch == 'a')a++;
            if(ch == 'l')l++;
            if(ch == 'o')o++;
            if(ch == 'n')n++;
        }
        int min = Integer.MAX_VALUE;
        if(b > 0 && a > 0 && n > 0 && l/2 >0 && o/2 > 0){
            min = Math.min(b, Math.min(a, Math.min(n, Math.min(l/2, o/2))));
        }
        if(min != Integer.MAX_VALUE) return min;
        return 0;
    }
}