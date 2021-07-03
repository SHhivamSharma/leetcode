/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
     public boolean roottonodepath(TreeNode root , int data , ArrayList<TreeNode> ans){
         if(root == null)
             return false;
          boolean res = (root.val == data) || roottonodepath(root.left , data , ans) || roottonodepath(root.right , data , ans) ;
         
         if(res){
             ans.add(root);
         }
         return res;
     }
         
    public void printatkdepth(TreeNode root ,TreeNode block ,int k , ArrayList<Integer> ans){
        if(root == null || root == block || k<0 ) return;
        
        if(k == 0){
            ans.add(root.val);
            
        }
        
        printatkdepth(root.left,block ,k-1 , ans);
         printatkdepth(root.right,block ,k-1 , ans);
 
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> path = new ArrayList<>();
        roottonodepath(root,target.val ,path);
        TreeNode block = null;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i<path.size(); i++){
           printatkdepth(path.get(i),block ,k-i,ans);
            block = path.get(i);
        }
        return ans;
        
    }
}
//============= SOLUTION 2=========
class Solution {
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNode n: queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }

        return new ArrayList<Integer>();
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
