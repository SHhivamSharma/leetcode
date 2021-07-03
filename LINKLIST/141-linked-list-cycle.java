/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
     public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        HashMap<ListNode,Boolean> map = new HashMap<>();
        while(head != null){
            if(map.containsKey(head)){
                return true;
            }else{
                map.put(head,true);
            }
            head = head.next;
        }
        return false;
    }
    //================ SOLUTION 2===============

//     public boolean hasCycle(ListNode head) {
//           ListNode slow =head;
//         ListNode fast = head.next;
//          while(slow!=fast){
//              if(fast==null || fast.next== null) {
//                  return false;
                 
//              }
             
//              slow=slow.next;
//              fast= fast.next.next;
//          }
//         return true;
             
//     }
}