class Solution {
    public int slidingPuzzle(int[][] board) {
        
        String target = "123450";
        
        String start = "";
        for(int i=0; i< board.length;i++){
            for(int j=0; j<board[i].length;j++){
                start+= board[i][j];
            }
        }
       
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(start);
        visited.add(start);
        // we added start to visited and queue also for doing bfs;
        
        int res =0; //starting number of moves.
        
        //direction vectors for swapping
        int[][] dirs = new int[][]{{1,3}, {0,2,4}, {1,5},{0,4},{1,3,5}, {2,4} };
        
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for (int i=0; i<size; i++){
                String val = queue.poll();
                if(val.equals(target)) return res;
                
                
                int zero = val.indexOf('0');
                
                for( int ints: dirs[zero]){
                    String next = swap(val,zero,ints);
                    if(visited.contains(next)) continue;
                    
                    visited.add(next);
                    queue.offer(next);
                }
            }
            res++;
        }
        
        return -1;
    }
    
        private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}