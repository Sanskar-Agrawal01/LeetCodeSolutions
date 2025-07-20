class Solution {
    public String generateTag(String caption) {
        if (caption.trim().isEmpty()) return "#";
         String[] str = caption.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        
        sb.append((str[0].length() > 100 ? str[0].substring(0, 99) : str[0]).toLowerCase());

        for (int i = 1; i < str.length; i++) {
            
            String s3 = str[i].length() > 100 ? str[i].substring(0, 99) : str[i];
            for (int j = 0; j < s3.length(); j++) {
                char ch = s3.charAt(j);
                if (j == 0) {
                    sb.append(Character.toUpperCase(ch));
                } else {
                    sb.append(Character.toLowerCase(ch));
                }
            }
        }
        return sb.length() > 100 ? sb.substring(0, 100) : sb.toString();
    }
}