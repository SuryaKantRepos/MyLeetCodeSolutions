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
    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> bfs = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        
        bfs.offer(root);
                
        while(!bfs.isEmpty()){
            int qSize = bfs.size();

            for(int i=0; i<qSize;i++){
                TreeNode node = bfs.poll();
                  if(node!=null) {
                        if(i == qSize-1) answerList.add(node.val);
                       if(node.left != null) bfs.offer(node.left);
                       if(node.right !=null) bfs.offer(node.right);
                    }
            }          
        }
        
    return answerList;
    }
}