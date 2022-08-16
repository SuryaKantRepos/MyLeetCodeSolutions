class Solution {
         private  int[][] memo;
    public int minPathSum(int[][] grid) {
                memo = new int[grid.length][grid[0].length];

        int j=0;
        while( j< memo.length){
            Arrays.fill(memo[j],-1);
            j++;
        }       
     return minCost(grid,0,0);
    }
    
   int  minCost(int[][] grid, int i, int j){
         int n = grid.length;
        int m = grid[0].length;

        if (memo[i][j] != -1) return memo[i][j];

        if(i == n-1 & j == m-1) return memo[i][j]= grid[i][j];
        if(i == n-1) return memo[i][j]= grid[i][j] + minCost(grid,i,j+1);
        if(j == m-1) return memo[i][j]=  grid[i][j] + minCost(grid,i+1,j);
        return memo[i][j]= grid[i][j] +Math.min(minCost(grid,i+1,j), minCost(grid,i,j+1));

    }
}