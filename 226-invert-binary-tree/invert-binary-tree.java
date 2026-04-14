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
    public TreeNode invertTree(TreeNode root) {
        if (root==null)return root;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cu=q.poll();
            TreeNode temp=cu.left;
            cu.left=cu.right;
            cu.right=temp;

            if(cu.left!=null)q.offer(cu.left);
            if(cu.right!=null)q.offer(cu.right);
        }
        return root;
    }
}