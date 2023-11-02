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
    int count;
    int sum, num;
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
       
        sum = 0; num = 0;
        check(root);

        if((sum/num) == root.val){
            count++;
        }

        traverse(root.right);
    }

    public void check(TreeNode root){
        if(root==null){
            return;
        }
        num++;
        check(root.left);
        sum += root.val;
        check(root.right);
    }

    public int averageOfSubtree(TreeNode root) {
        count = 0;
        if(root == null){
            return 0;
        }
        traverse(root);

        return count;
    }
}