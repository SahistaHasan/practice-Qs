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
        ListNode temp = head;
        ListNode temp2=null;
        ListNode temp3=null;
        while(temp!=null){
            temp2=temp.next;
            temp.next=temp3;
            temp3=temp;
            temp=temp2;
        }
        return temp3;
    }
    public ListNode findk(ListNode head,int k){
        ListNode temp=head;
        int count=1;
        while(count!=k){
            if(temp==null) return null;
            temp=temp.next;
            count++;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp=head;
        ListNode prevNode = null;
        while(temp!=null){
        ListNode kth=findk(temp,k);
        if(kth==null){
            if(prevNode!=null) {
                prevNode.next=temp;
                break;
            }
        }
        ListNode nextNode = kth.next;
        kth.next=null;
        reverse(temp);
        if(temp==head) {
                head=kth;
            }else {
                prevNode.next= kth;
            }
        prevNode=temp;
        
        temp=nextNode;


    }
    return head;
    }
}