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
    
       
    
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        ListNode p1=null;
        ListNode p2=head;
        while(p2!=null){
            if(set.contains(p2.val)){

                if(p1==null){
                   head=p2.next;
                   p2=p2.next;
                 }
                 else{
                 p1.next=p2.next;
                 p2=p1.next;
                 }
            }
            else {
                p1=p2;
                p2=p2.next;
            }
          
        }
        return head;
    }
}