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
    int prev = Integer.MAX_VALUE;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        preorder(root);

        return res;
    }
    public void preorder(TreeNode root){
        if(root.left != null) preorder(root.left);
        res = Math.min(Math.abs(prev-root.val), res);
        prev = root.val;
        System.out.println(prev+" "+res);
        
        if(root.right != null) preorder(root.right);
    }
}
