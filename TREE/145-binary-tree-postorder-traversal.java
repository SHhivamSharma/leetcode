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
    ArrayList<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null ){
            return ans;
        }
        
        post(root);
        return ans;
        
    }
    
    public void post(TreeNode root){
        if(root == null ){
            return;
        }
        post(root.left);
        post(root.right);
        ans.add(root.val);
        
    }
}