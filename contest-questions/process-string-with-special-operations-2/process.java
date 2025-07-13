class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
    
        long length = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (length > 0) length--;
            } else if (ch == '#') {
                length *= 2;
            } else if (ch == '%') {
               
            } else {
                length++;
            }
        }
        if (length == 0 || k >= length) return '.';

      
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '*') {
                
               
                if (length < Long.MAX_VALUE) length++; 
                if (k == length - 1) return '.'; 
            } else if (ch == '#') {
            
                long prevLen = length / 2;
                if (k >= prevLen) k -= prevLen;
                length = prevLen;
            } else if (ch == '%') {
                k = length - 1 - k;
            } else {
                if (k == length - 1) return ch;
                length--;
            }
        }
        return '.';
    }
}
