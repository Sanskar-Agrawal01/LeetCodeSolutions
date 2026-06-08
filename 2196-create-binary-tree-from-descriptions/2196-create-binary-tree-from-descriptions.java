/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
       Set<Integer> set = new HashSet<>();
        for(int nums[] : descriptions){
            int root = nums[0];
            set.add(root);
        }
        for(int nums[] : descriptions){
            int child = nums[1];
            if(set.contains(child)) set.remove(Integer.valueOf(child));
        }
        int val = set.iterator().next();
        TreeNode root = new TreeNode(val);
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        for(int nums[] : descriptions){
            int root2 = nums[0];
            int child = nums[1];
            int ileft = nums[2];
            if(ileft == 1){
                left.put(root2, child);
            }
            else{
                right.put(root2, child);
            }
        }
        build(left, right, root);
        return root;
    }
    public static TreeNode build(HashMap<Integer, Integer> left, HashMap<Integer, Integer> right, TreeNode root){
        if(root == null ) return null;
        if(left.get(root.val) == null){
            root.left = null;
        }
        else{
           root.left = new TreeNode(left.get(root.val));
        }
        if(right.get(root.val) == null){
            root.right = null;
        }
        else{
             root.right = new TreeNode(right.get(root.val));
        } 
         root.left = build(left, right, root.left);
         root.right  = build(left, right, root.right);
         return  root;
    }
}