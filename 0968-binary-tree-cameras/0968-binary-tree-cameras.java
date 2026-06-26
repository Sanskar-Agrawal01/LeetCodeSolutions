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
     int flips = 0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root) == 0) flips++;
        return flips;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 2;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);

        if(l == 0 || r == 0){
            flips++;
            return 1;
        }
        if(l == 1 || r == 1){
            return 2;
        }
        return 0;
    }
}