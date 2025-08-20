class Solution {

    public int countSquares(int[][] matrix) {
            

          int m = matrix.length;
          int n = matrix[0].length;

          int totalSubMatrices = 0;  
          int[][] dp = new int[m][n]; 
          for(int[] d : dp) {
               Arrays.fill(d, -1);
          }
          for(int i = 0; i<m; i++) {
               for(int j = 0; j<n; j++) {
                       
                      if(matrix[i][j] != 0) {
                           totalSubMatrices += f(matrix, dp,  i, j, m, n);
                      }   
               }
          }  


          return totalSubMatrices;
    }

    private int f(int[][] matrix, int[][] dp,  int i, int j, int m, int n) {
              // base case 
              if(i == m || j == n || matrix[i][j] == 0) {
                  return 0;
              }

             if(dp[i][j] != -1) {
                  return dp[i][j];
             }    
              
             int right = f(matrix, dp,  i, j+1, m, n);
             int diagonal = f(matrix, dp,  i+1, j+1, m, n);
             int down = f(matrix,dp,  i+1, j, m, n); 


             return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));  
    }
}