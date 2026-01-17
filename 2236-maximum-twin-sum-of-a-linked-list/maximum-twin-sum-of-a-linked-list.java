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
    public ListNode reverse(ListNode head){
        ListNode temp1=null;
        ListNode temp2=head;
        while(temp2!=null){
            temp2=head.next;
            head.next=temp1;
            temp1=head;
            head=temp2;


        }
        return temp1;
    }
    public int pairSum(ListNode head) {
        ListNode temp1=head;
        ListNode temp2=head;
        int len=0;
        while(temp2!=null){
            temp2=temp2.next;
            len++;
        }
        int max=Integer.MIN_VALUE;
        temp2=head;
        int count=0;
        ListNode prev = null;
        while(count!=len/2){
           prev=temp2;
           temp2=temp2.next;
           count++;
        }
        prev.next=null;
        ListNode temp3 =reverse(temp2);
        count=0;
        while(count!=len/2){
            max=Math.max(max,temp1.val+temp3.val);
            temp1=temp1.next;
            temp3=temp3.next;
            count++;
        }
return max;
    }
}