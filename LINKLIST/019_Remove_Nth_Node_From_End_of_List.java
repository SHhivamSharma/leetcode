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
    public ListNode removeNthFromEnd(ListNode head, int n) {
//           ListNode slow, fast, curr;
//         slow = head; fast = head;
//         for (int i = 0; i < n; i++)
//             fast = fast.next;
      
//         if (fast == null) {
//             head = head.next;
//             return head;
//         }
         
//         while (fast.next != null) {
//             fast = fast.next;
//             slow = slow.next;
//         }
//         curr = slow.next;
//          slow.next = curr.next;
//         return head;
        
         ListNode curr = head;
        int ls = 0;
        while (curr != null) {
            curr = curr.next;
            ls++;
        }       
        if (ls == n) {
            if (ls > 1) return head.next;
            return null;
        }
        curr = head;   
        for (int i = 0; i < ls - n - 1; i++) {
            curr = curr.next;
        }
     
        curr.next = curr.next.next;
        return head;

    }
}