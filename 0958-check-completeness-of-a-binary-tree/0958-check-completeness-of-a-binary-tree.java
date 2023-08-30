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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        boolean gotNullSoFar = false;
        
        while(!bfs.isEmpty()){
            TreeNode top = bfs.poll();
            
            if(top == null){
                gotNullSoFar = true;
            }else{
                if(gotNullSoFar) return false;
                bfs.offer(top.left);
                bfs.offer(top.right);
            }
        }
    return true;
    }
}