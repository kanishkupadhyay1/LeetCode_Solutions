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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode cu=head,cuu=head;int c=1;
        while(cu.next!=null){
            c+=1;
            cu=cu.next;
        }
        k%=c;
        if(k==0){
            return head;
        }
        int x=c-k,y=0;
        ListNode newtail=head;
       for(int i=1;i<x;i++){
        newtail=newtail.next;
       }
       ListNode newhead=newtail.next;
            newtail.next=null;
            cu.next=head;
        

    return newhead;    
    }
}