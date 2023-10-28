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
        if(head==null || k==0) return head;
        ListNode curr=head;
        int count=1;
        while(curr.next!=null){
            curr=curr.next;
            count++;
       }
        k=k%count;
        if(k==0) return head;
        curr.next=head;
        ListNode newhead=head;
        for(int i=0;i<count-k-1;i++){
            newhead=newhead.next;
            // this would go until the prev element of 1st rotated element
        }
       
       ListNode result=newhead.next;
    //    initialize a new node since we will be cutting off and we need to pass this as 1st element in our result
       newhead.next=null;
    //    cut off the link

       return result;
    }
}