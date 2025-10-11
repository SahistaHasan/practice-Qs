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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start1=list1;
        for(int i=0;i<a-1;i++){
            start1=start1.next;
        }
        ListNode end1=list1;
        for(int i=0;i<b;i++){
          end1=end1.next;
        }
       ListNode end_1=end1.next;
        end1.next=null;
        ListNode end2=list2;
        while(end2.next!=null){
            end2=end2.next;
        }
     start1.next=list2;
     end2.next= end_1;
     return list1;

    }
}