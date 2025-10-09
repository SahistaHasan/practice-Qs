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
    public int[] nextLargerNodes(ListNode head) {
        ListNode p1=null;
        ListNode p2=head;
        ListNode p3=head;
        ListNode temp=head;
        int count=0;
        while(temp!=null){
         temp=temp.next;
         count++;
        }
        while(p2!=null){
            p3=p3.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }
        head=p1;
        Stack<Integer> stack=new Stack<>();
        int [] ans = new int[count];
        int no=count-1;
        while(head!=null){
            while( !stack.isEmpty() && stack.peek()<=head.val ){
                  stack.pop();
            }
            if(stack.isEmpty()) ans[no]=0;
            else{
                ans[no]=stack.peek();
            }
            stack.push(head.val);
            head=head.next;
            no--;
        }
        return ans;
    }
}