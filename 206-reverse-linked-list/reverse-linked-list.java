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
    public ListNode reverseList(ListNode head) {

        ListNode prev=null,cu=head;

        while(cu!=null){
            ListNode next=cu.next;
            cu.next=prev;
            prev=cu;
            cu=next;
        }

        return prev;
        
    }
}