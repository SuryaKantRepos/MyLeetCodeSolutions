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
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode answer = new ListNode(-1);
        
        ListNode point = answer;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val-b.val);
        
        
        for(ListNode head : lists){
           if(head != null) minHeap.offer(head);
        } /// Pushed all the head of LLs
        //Now get the Top min Value....add it to answer.
        //pick the next element of top Min and push it to PQ.
        
        //answer is getting from Top.....once all the elements are added Quueue becomes empty.
        
        while(!minHeap.isEmpty()){
            ListNode topMin = minHeap.poll();
            ListNode min = new ListNode(topMin.val);
            point.next = min;
            point = point.next; ////answer moved by one element.
            
            
            ListNode nextOnetoCheck = topMin.next;
            if(nextOnetoCheck !=null) minHeap.offer(nextOnetoCheck);
        }
        
      return answer.next;  
    }
}