class Solution {
    public int trapRainWater(int[][] heightMap) {
          
          int m = heightMap.length;
          int n = heightMap[0].length;

          if(m <= 2 || n <= 2) return 0;

            
          Queue<int[]> minHeap = new PriorityQueue<>((h1, h2)-> h1[0] - h2[0]); 
          boolean[][] vis = new boolean[m][n];
          
          int firstRow = 0;
          int lastRow = m-1;
          for(int j = 0; j<n; j++) {
                     minHeap.offer(new int[]{heightMap[firstRow][j], firstRow, j}); // first row
                     minHeap.offer(new int[]{heightMap[lastRow][j], lastRow, j}); // last row

                     vis[firstRow][j] = true;
                     vis[lastRow][j] = true;
          }
          
          

          int firstCol = 0;
          int lastCol = n-1;

          for(int i = 1; i<m-1; i++) {
                minHeap.offer(new int[]{heightMap[i][firstCol], i, firstCol}); // first Col
                minHeap.offer(new int[]{heightMap[i][lastCol], i, lastCol}); // lastCol

                vis[i][firstCol] = true;
                vis[i][lastCol] = true;
          }
            
           

                       //        left     right    up      down 
          int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; 
          int totalTrapped = 0;  
          while(!minHeap.isEmpty()) {
                  
                  int[] cell = minHeap.poll();
                  
                  int currHeight = cell[0];
                  int i = cell[1];
                  int j = cell[2];

                  for(int[] dir : directions) {
                        int new_i = i +  dir[0];
                        int new_j = j +  dir[1];

                        if(new_i >= 0 && new_j >= 0 && new_i < m && new_j < n && !vis[new_i][new_j]) {
                                 totalTrapped += Math.max(0, currHeight - heightMap[new_i][new_j]);
                                
                                 heightMap[new_i][new_j] = Math.max(
                                       heightMap[new_i][new_j], currHeight
                                   );

                                 minHeap.offer(new int[]{heightMap[new_i][new_j], new_i, new_j});

                                 vis[new_i][new_j] = true;
                        }
                  }
          }

          return totalTrapped;
        
    }
}