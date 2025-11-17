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
    public int gcdfun(int val1,int val2){
        int ans=Integer.MIN_VALUE;
        int min=Math.min(val1,val2);
        for(int i=1;i<=min;i++){
            if(val1%i==0 && val2%i==0){
                ans=Math.max(i,ans);
            }
        }
        return ans;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null) return head;
        ListNode temp1=head;
        ListNode temp2=head.next;
        while(temp2!=null){
            int gcd = gcdfun(temp1.val,temp2.val);
            ListNode temp=new ListNode(gcd);
            temp1.next=temp;
            temp.next=temp2;
            temp1=temp2;
            temp2=temp2.next;
        }
        return head;
    }
}