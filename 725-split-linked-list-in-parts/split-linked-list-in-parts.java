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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        int div=len/k;
        int rem=len%k;
        int iter=0;
        int count=0;
        ListNode temp1=head;
        ListNode[] parts = new ListNode[k];
        int cur=0;
        int i=0;
       if (k > len) {
            // more parts than nodes
            while (temp1 != null) {
                ListNode next = temp1.next;  // save next node
                temp1.next = null;           // disconnect current node
                parts[iter++] = temp1;
                temp1 = next;                // move to next node
            }
            return parts;
        }
        while(temp1!=null){
           ListNode currhead=temp1;
           ListNode end=temp1;
          
            while(count!=div && temp1!=null ){
                end=temp1;
                temp1=temp1.next;
                count++;
                cur++;
            }
           if(rem>0 && temp1!=null){
            end=temp1;
            temp1=temp1.next;
            cur++;
           }
           rem--;
           end.next=null;
           parts[iter]=currhead;
           iter++;
           count=0;

        }
    return parts;
    }
}