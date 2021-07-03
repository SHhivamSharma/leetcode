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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        int l = left -1, r = right -1,itr = (r-l)+1;
        ListNode prev = new ListNode(-1);
        ListNode lnode = head,temp = prev;
        prev.next = head;
        while(l-->0){
            prev = prev.next;
            lnode = lnode.next;            
        }
        ListNode[] HTF = reverse(lnode,itr);
        HTF[1].next = HTF[2];
        if(prev != temp){
            prev.next = HTF[0];
            return head;
        }else{
            return HTF[0];
        }
                   
    }
    
    public ListNode[] reverse(ListNode head, int n){
        ListNode[] arr = new ListNode[3];
        Arrays.fill(arr,head);
        arr[2] =null;
        if(head == null || head.next == null) return arr;
        ListNode prev = null, cur = head;
        while(n-->0){
            ListNode f = cur.next;
            cur.next = prev;
            prev = cur;
            cur = f;
        }
        arr[0] = prev;
        arr[1] = head;
        arr[2] = cur;
        return arr;
        
    }
}

//=============================== SOLUTION 2============================================================
 public void addFirstNode(ListNode node) {
        if (th == null)
            th = tt = node;
        else {
            node.next = th;
            th = node;
        }
    }

 public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null || m == n)
            return head;
        int i = 1;
        ListNode curr = head, prev = null;
        while (curr != null) {
            while (i >= m && i <= n) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
                i++;
            }

            if (i > n) {
                if (prev == null) {
                    tt.next = curr;
                    return th;
                } else {
                    prev.next = th;
                    tt.next = curr;
                    return head;
                }
            }

            prev = curr;
            curr = curr.next;
            i++;
        }

        return null;
    }