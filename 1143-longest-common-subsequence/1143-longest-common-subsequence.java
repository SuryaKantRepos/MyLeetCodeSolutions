class Solution {
    int memo[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int m= text1.length();
        int n = text2.length();
        memo = new int[1001][1001];
        
        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++){
                memo[i][j] = -1;
            }
        }
        return longest(text1,text2,m-1,n-1);
    }
    
    int longest(String text1, String text2, int idx1, int idx2){
        if(idx1 <0 || idx2<0) return 0;
        if(memo[idx1][idx2] !=-1) return memo[idx1][idx2];
        
        if(text1.charAt(idx1) == text2.charAt(idx2)){
            return memo[idx1][idx2] = 1 + longest(text1,text2, idx1-1, idx2-1);
        }
        
        return memo[idx1][idx2] = Math.max( longest(text1,text2,idx1-1,idx2) , longest(text1,text2,idx1,idx2-1));
    }
}