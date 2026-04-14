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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode cu=q.poll();
            if(cu.left!=null && cu.left.left==null && cu.left.right==null){
                sum+=cu.left.val;
            }

            if(cu.left!=null)q.offer(cu.left);
            if(cu.right!=null)q.offer(cu.right);
            
        }
        return sum;
    }
}