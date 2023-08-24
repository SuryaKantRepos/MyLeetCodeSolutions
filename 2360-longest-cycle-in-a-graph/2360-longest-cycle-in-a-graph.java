class Solution {
    Boolean[] visited;
    int answer =-1;
    public int longestCycle(int[] edges) {
        
        //Every node can be part of only one cycle....
        
        //So we need to visit all nodes  which is O(n) 
        visited = new Boolean[edges.length];
        
        Arrays.fill(visited, false);
        
        for(int i=0;i< edges.length; i++){
            if(!visited[i]){
            Map<Integer,Integer> distMap = new HashMap<>();
                distMap.put(i,1);
                dfs(i,edges,visited,distMap);
            }
        }
    return answer;
    }
    
    void dfs(int node, int[]edges,Boolean[] visited, Map<Integer,Integer> distMap){
        visited[node] = true; //mark item as visited.
        int neighbour = edges[node]; // get its neighbour.
        
        if(neighbour!=-1 && !visited[neighbour]){
            distMap.put(neighbour, distMap.get(node)+1);
            dfs(neighbour, edges,visited,distMap);
        }else if(neighbour !=-1 && distMap.containsKey(neighbour)){
            //cycle found
            answer = Math.max(answer, (distMap.get(node) -distMap.get(neighbour) +1));
        }
        
    }
    
}