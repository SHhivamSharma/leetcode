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
   public ListNode mergeKLists(ListNode[] arr) {
        if(arr.length == 0)return null;
        int ei = arr.length-1;
        while(ei != 0){
            int i=0, j= ei;
            while(i<j){
                arr[i] = mergeTwoLists(arr[i],arr[j]);
                i++;
                j--;
                
                if(i>=j){ ei = j; }
            }            
        }
        return arr[0];
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 =l2;
        ListNode temp = new ListNode(-1,null), ans = temp;
        while(c1 != null && c2 != null){
            if(c1.val <= c2.val){
                temp.next = c1; c1 = c1.next;
            }else{
                temp.next = c2; c2 = c2.next;
            }
            temp = temp.next;
        }
        temp.next = (c1 == null) ? c2 : c1;
        ans = ans.next;
        return ans;
    }
}