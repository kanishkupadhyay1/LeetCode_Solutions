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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int s=q.size();
            double avg=0;
            

            for(int i=0;i<s;i++){
                TreeNode c=q.poll();
                avg+=c.val;

                if(c.left!=null)q.offer(c.left);
                if(c.right!=null)q.offer(c.right);
            }
            avg/=s;
            ans.add(avg);
        }
        return ans;
    }
}