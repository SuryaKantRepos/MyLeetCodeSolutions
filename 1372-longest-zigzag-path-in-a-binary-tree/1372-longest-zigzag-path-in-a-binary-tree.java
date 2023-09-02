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
    int maxLength =0;
    public int longestZigZag(TreeNode root) {
        solve(root,0,0);
        solve(root,1,0);
        return maxLength;
        
    }
    
    int solve(TreeNode root, int incomingDirection, int currentLength ){
        if(root == null) return 0;
        maxLength = Math.max(maxLength,currentLength);
        
        solve(root.left, 0 , incomingDirection==0?1:currentLength+1);
        solve(root.right,1, incomingDirection==1?1:currentLength+1);
        return maxLength;
    }
}