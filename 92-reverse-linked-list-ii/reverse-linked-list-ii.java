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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
       ListNode left_prev=head;
       if(left==1) left_prev=null;
      
       else{
       for(int i=1;i<left-1;i++){
         left_prev=left_prev.next;
       }
       }
       ListNode p1;
       if(left_prev==null) p1=head;
       else p1=left_prev.next;
       ListNode leftnode=p1;
       ListNode p2=p1.next;
       ListNode p3=p2;
       int count=0;
       while(count!=right-left){
        p3=p2.next;
        p2.next=p1;
        p1=p2;
        p2=p3;
        count++;
       }
       if(left_prev!=null){
       left_prev.next=p1;
       }
       else{
        head=p1;
       }
       leftnode.next=p2;
       
       return head;

    


    }
}