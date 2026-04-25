/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root==null)return root;

        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        

        while(!q.isEmpty()){
            int s=q.size();
            Node prev=null;
            
            for(int i=0;i<s;i++){
                Node c=q.poll();

                if(prev!=null) prev.next=c;
                prev=c;

                if(c.left!=null)q.offer(c.left);
                if(c.right!=null)q.offer(c.right);
            }
            prev.next=null;
        }
        return root;
    }
}