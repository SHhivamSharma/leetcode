import java.util.Scanner;
public class two_2{
   
   class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
    	ListNode p = l1, q= l2, curr = dummyHead;
    	int carry = 0;
    	while (p != null || q!= null) {
             int x = 0;
            if (p != null){
               x =  p.val;
                
            }
             
    		int y =0;
            if (q != null)  {
             y=q.val;   
            }   
    		int digit = carry + x + y;
    		carry = digit / 10;
    		curr.next = new ListNode(digit % 10);
    		curr = curr.next;
    		if (p != null) p = p.next;
    		if (q != null) q = q.next;
    	}
    	if (carry > 0) {
    		curr.next = new ListNode(carry);
    	}
    	return dummyHead.next;
        
    }
}
 
}