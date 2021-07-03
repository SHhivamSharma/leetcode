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
    public ListNode partition(ListNode head, int x) {
        
          ListNode small = new ListNode(0);
        ListNode higher = new ListNode(0);
        
        ListNode smallHead=small, higherHead = higher;
        
        while(head!=null){
            if(head.val<x){
                //small list
                smallHead.next = head;
                smallHead = smallHead.next;
            }
            else{
                //high list
                higherHead.next = head;
                higherHead = higherHead.next;
            }
            head=head.next;
        }
        
        higherHead.next = null;
        smallHead.next = higher.next;
        
        return small.next;
        
        //  if(head == null || head.next == null) return head;
        // ListNode large = new ListNode(-1);
        // ListNode small = new ListNode(-1);
        // ListNode sp = small, lp = large,cur = head;
        // while(cur != null){
        //     if(cur.val < x){
        //         sp.next = cur;
        //         sp = cur;
        //     }else{
        //         lp.next = cur;
        //         lp = cur;
        //     }
        //     cur = cur.next;
        // }
        // sp.next = large.next;
        // lp.next = null;
        // cur= small.next;
        // large.next = small.next = null;
        // return cur;
    }
}