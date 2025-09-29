class Solution {
    public int minScoreTriangulation(int[] values) {
            
           int[][] dp = new int[values.length][values.length];
           for(int[] d : dp) Arrays.fill(d, -1); 
           return solve(values, dp,  0, values.length-1);
    }


    private int solve(int[] values, int[][] dp, int i, int j) {
            
           if(j - i + 1 < 3) return 0; 
           
           if(dp[i][j] != -1) return dp[i][j];

           int res = Integer.MAX_VALUE;  
           for(int k = i+1; k<j; k++) {
               int sol = (values[i] * values[j] * values[k]) 
                          + solve(values, dp,  i, k) + solve(values, dp, k, j);

               res = Math.min(sol, res);            
           }

           return dp[i][j] = res;
    }
}