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
   public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
         

        while(prev != null){
            prev = reverseKNode(prev,k);
        }
    
        return dummy.next;

    }

    // head->n1->n2....nk->nk+1
    // head->nk->nk-1....n1->nk+1

    private ListNode reverseKNode(ListNode prevNode, int k){

        ListNode n1 = prevNode.next; //record original head

        ListNode curt = prevNode;
        for(int i = 0 ; i < k ; i++){
            curt = curt.next;
            if(curt == null){
                return null;
            }
        }

        ListNode nk = curt; //record the original tail
        ListNode nkplus = curt.next; //record the original tail.next

        //re-run the nodes from head
        ListNode prev = prevNode;
        ListNode cur = prevNode.next;
        while (cur != nkplus){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        prevNode.next = nk;
        n1.next = nkplus;

        return n1; //return prev ; n1 is the next prev node
    }
}


//================ SOLUTION 2===============
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
    public static int length(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        return len;
    }
     ListNode th = null;
    ListNode tt = null;

 
      public void addFirstNode(ListNode node){
        if(th == null){
            th = tt = node;
        }else{
            node.next = th;
            th=node;
        }
        
    }

 
  
   public ListNode reverseKGroup(ListNode head, int k)  {
       if(k == 1 ||head.next==null)
           return head;
       ListNode curr= head;
       ListNode ph = null;
       ListNode pt = null ;
      
       int len = length(head);
       
       while(curr!=null && len>=k){
            int itr = k;
           while(itr-- > 0){
               ListNode frw = curr.next;
               curr.next=null;
               addFirstNode(curr);
               curr = frw;
               
           }
           if(ph == null){
               ph = th;
               pt=tt;
           }
           else{
               pt.next=th;
               pt=tt;
           }
           th = tt = null;
           len = len - k;
       }
       
       pt.next=curr;
       return ph;
   }
}