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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        inor(root,ans);
        return ans;

        
        
    }

    public void inor(TreeNode root, List<Integer> res){
        if(root==null) return;
        
        inor(root.left,res);
        res.add(root.val);       
        inor(root.right,res);

        

    }
}