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
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp1=head;
        ListNode temp2=head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode temp3=dummy;
        while(temp1!=null){
            temp1=temp1.next;
            if(temp2.val==val){
                temp3.next=temp1;
                temp2.next=null;
                temp2=temp1;
            }
            else{
                temp3=temp2;
                temp2=temp2.next;
                
            }
        }
        return dummy.next;
    }
}