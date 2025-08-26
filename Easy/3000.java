class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
         
          double max = 0;
          int area = 0;   
          for(int[] dimension : dimensions) {
                int len = dimension[0];
                int width = dimension[1];
               
                int cal = (len * len) + (width * width);
                double diagonalLen = Math.sqrt(cal);

                if(diagonalLen >= max) {
                       area = (diagonalLen == max) ? Math.max(area, len * width) : len * width;
                       max = diagonalLen;
                }
          } 

          return area; 
    } 
}