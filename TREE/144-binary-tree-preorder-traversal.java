/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   
    
    List<Integer> retVal = new LinkedList<>();
     public List<Integer> preorderTraversal(TreeNode root) {
         if(root == null) return retVal;
         preOrder(root);
         return retVal;
     }
    
     private void preOrder(TreeNode node){
         if(node == null) return;
         retVal.add(node.val);
         preOrder(node.left);
         preOrder(node.right);
     }
}