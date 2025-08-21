class Solution {
    public int numSubmat(int[][] mat) {
        

        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i<m; i++) {
               for(int j = n-1; j>=0; j--) {

                   if(mat[i][j] != 0)    
                       mat[i][j] += (j + 1 < n && mat[i][j+1] != 0) ? mat[i][j+1] : 0;   
               }
        }  
           

       

        int totalSubMatrices = 0;  
        for(int i = 0; i<m; i++) {
              for(int j = 0; j<n; j++) {

                      int min = Integer.MAX_VALUE; 
                      for(int k = i; k < m; k++) {
                           min = Math.min(min, mat[k][j]);
                           totalSubMatrices += min;
                      } 
              }
        }


        return totalSubMatrices;
    }
}