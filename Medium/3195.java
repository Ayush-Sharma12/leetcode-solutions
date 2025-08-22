class Solution {
    public int minimumArea(int[][] grid) {
           
           int m = grid.length;
           int n = grid[0].length;
          // for length
           int upperLen = 0;
           for(int i = 0; i<m; i++) {

               boolean flag = false;
               for(int j = 0; j<n; j++) {
                      if(grid[i][j] == 1) {
                           upperLen = i;
                           flag = true;
                           break;
                      }
               }

               if(flag) break;
           }

           int lowerLen = 0;
           for(int i = m-1; i>=0; i--) {

               boolean flag = false;
               for(int j = 0; j<n; j++) {
                      if(grid[i][j] == 1) {
                           lowerLen = i;
                           flag = true;
                           break;
                      }
               }

               if(flag) break;
           }  

        // for breadth
           int start = 0;
           for(int j = 0; j<n; j++) {

               boolean flag = false;
               for(int i = 0; i<m; i++) {
                     if(grid[i][j] == 1) {
                          start = j;
                          flag = true;
                          break;
                     }
               }

               if(flag) break;
           }

           int end = 0;
           for(int j = n-1; j>=0; j--) {
               boolean flag = false;
               for(int i = 0; i<m; i++) {
                     if(grid[i][j] == 1) {
                          end = j;
                          flag = true;
                          break;
                     }
               }

               if(flag) break;
           }


           // calculate the Area Of Rectangle

           int length = lowerLen - upperLen + 1;

           int breadth = end - start + 1;


           return length * breadth;



    }
}