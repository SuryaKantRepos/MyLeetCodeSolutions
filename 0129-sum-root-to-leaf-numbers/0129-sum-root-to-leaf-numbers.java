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
    public int sumNumbers(TreeNode root) {
        int currentSum =0;
        return sumHelper(root, currentSum);
        
    }
    int sumHelper(TreeNode root,int currentSum ){
        if(root == null) return 0;
        currentSum = 10*currentSum + root.val;
        if(root.left == null && root.right == null) return currentSum;
        
        int leftSum = sumHelper(root.left, currentSum);
        int rightSum = sumHelper(root.right,currentSum);
        
        return leftSum+rightSum;
    }
}