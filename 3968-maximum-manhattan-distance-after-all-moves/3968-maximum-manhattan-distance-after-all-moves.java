class Solution {
    public int maxDistance(String moves) {
        int dist = 0;
        int l = 0;
        int r = 0;
        int u = 0;
        int d = 0;
        int b = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'L' ) l++;
            else if(ch == 'R') r++;
            else if(ch == 'U' ) u++;
            else if(ch == 'D')d++;
            else if (ch == '_') b++;
        }
        dist = Math.abs(l - r) + Math.abs(u - d);
        if(b == 0) return dist;
        return dist + b;
    }
}