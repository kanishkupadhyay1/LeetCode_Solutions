/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dh=new ListNode(0);
        ListNode p=l1,q=l2,current=dh;
        int c=0;
        while(p!=null || q!=null){
            int x=(p!=null)?p.val:0;
            int y=q!=null ? q.val:0;
            int sum=c+x+y;
            c=sum/10;
            current.next=new ListNode(sum%10);
            current=current.next;
            if(p!=null)p=p.next;
            if(q!=null)q=q.next;
        }
        if(c>0){
            current.next=new ListNode(c);
        }
        return dh.next;
        
    }
}