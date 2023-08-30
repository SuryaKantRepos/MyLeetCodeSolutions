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
    public TreeNode sortedListToBST(ListNode head) {
                //understanding the problem:
        // 1 did you understand all parts of the problem.
        // are you able to create an example....
        // are you able to see both answer and given....
        
        //  Converting something to some data struture problems.... look at first element of the new data structure....what is it?
        //Here key observation is middle of the linked list is root of the BST.... and recursively midlle of the list is left and right sub tree.
        
        if(head == null) return null;
        return convertToBST(head,null); //take start and end pointers
        
    }
    
    TreeNode convertToBST(ListNode start, ListNode end){
        if(start== end) return null;
        ListNode slow = start;
        ListNode fast = start;
        
        while(fast!=end && fast.next!=end){
            slow =slow.next;
            fast = fast.next.next;
        }
        
        //find middle.
        ListNode middle =slow;
        
        
        TreeNode bst = new TreeNode(middle.val);
        bst.left = convertToBST(start,middle);
        bst.right = convertToBST(middle.next, end);
        
        return bst;
    }
}