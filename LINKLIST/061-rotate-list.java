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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int size = 0;
        ListNode cur = head;
        while(cur != null){
           
            cur = cur.next;
             size++;
        }
        k = k%size;
        if(k == 0){return head;}
        k = size - k;
        cur = head;
        ListNode f = null;
        while(k-->1){
            cur = cur.next;            
        }
        f = cur.next;
        cur.next = null;
        ListNode temp = f;
        // ListNode rev = reverse(f),temp = rev;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        return f;
        
    }
//     public ListNode rotateRight(ListNode head, int k) {
//        if(head ==null || head.next ==null) return head;
        
//         if (k == 0)
//         return head;
        
// //      ListNode curr = head;
// //         int ls = 0;
// //         while (curr != null) {
// //             curr = curr.next;
// //             ls++;
// //         }  
        
// //         int k1 = k%ls;
        
        
 
//     // Let us understand the below
//     // code for example k = 4 and
//     // list = 10.20.30.40.50.60.
//     ListNode current = head;
//  int c=0;
//     // Traverse till the end.
//     while (current.next != null)
//         current = current.next;
//  c++;
//     current.next = head;
//     current = head;
 
//     // traverse the linked list to k-1 position which
//     // will be last element for rotated array.
        
//         int k1= k%c   ;
        
//     for (int i = 0; i <= k1-1 ; i++)
//         current = current.next;
 
//     // update the head_ref and last element pointer to null
//     head = current.next;
//     current.next = null;
//         return head;
 
}