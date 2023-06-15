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
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int count = 0;
        int max = Integer.MIN_VALUE, level = 0;

        while(!q.isEmpty()){
            int sum = 0;
            count++;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            System.out.println(sum);
            if(sum>max){
                max = sum;
                level = count;
            }
        }
        return level;
    }
}