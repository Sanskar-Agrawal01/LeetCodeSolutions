/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode l1 = lowestCommonAncestor(root.left, p, q);
        TreeNode l2 = lowestCommonAncestor(root.right, p, q);
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        return root;
    }
}