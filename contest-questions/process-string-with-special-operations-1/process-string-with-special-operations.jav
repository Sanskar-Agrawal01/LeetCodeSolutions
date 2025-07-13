class Solution {
    public String processStr(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {

                if (!st.isEmpty()) {
                    st.pop();
                    str.deleteCharAt(str.length() - 1);
                }
            } else if (ch == '#') {
                String current = str.toString();
                str.append(current);
                for (char c : current.toCharArray()) {
                    st.push(c); 
            }
            }

            else if (ch == '%') {
                str.reverse();
            } else {
                st.push(ch);
                str.append(ch);
            }
        }
        return str.toString();
    }
}