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
    Map<Integer, Integer> map;
    int max = -1;
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        max = Math.max(map.get(root.val), max);
        traverse(root.right);
    }

    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }

        map = new HashMap<>();
        traverse(root);    

        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            if(m.getValue() == max){
                list.add(m.getKey());
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}