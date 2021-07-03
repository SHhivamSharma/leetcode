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
    public ListNode middleNode(ListNode head) {
         if (head == null || head.next == null)     return head;

     
     ListNode slow = head;
     ListNode fast = head;
     
     while(fast != null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;
         
     }
     return slow;

        
    }
}
//=========== SOLUTION 2 =======

    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
     
}