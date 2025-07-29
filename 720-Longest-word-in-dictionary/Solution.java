
    class Node{
        Node[] children  = new Node[26];
        boolean eow = false;
    }
    public  Node root = new Node();
    public static String ans = "";

    public static void ansLong(Node root,StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i =0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                ansLong(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public void insert(String word) {
        Node curr = root;
        for(int lvl = 0;lvl<word.length();lvl++){
            int idx = word.charAt(lvl) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public String longestWord(String[] words) {
        ans ="";
        
        for(int i = 0;i< words.length;i++){
            insert(words[i]);
        }
        StringBuilder temp = new StringBuilder();
        ansLong(root,temp);

        return ans;
    }
