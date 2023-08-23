class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
                                                     
        for(int i=0; i<k;i++){
            pq.offer(arr[i]);
        }
        
        for(int i = k; i<n;i++){
            if(Math.abs(pq.peek() -x) > Math.abs(arr[i]-x)){
            pq.poll();
            pq.offer(arr[i]);   
            }
        }
        List<Integer> answerList = new ArrayList<>();
        while(!pq.isEmpty()){
            answerList.add(pq.poll());
        }
        return answerList;
    }
}