class Solution {
    public int[][] sortMatrix(int[][] grid) {
           
             int n = grid.length; 
            // sort bottom diagonal in decreasing order
            for(int i = 0; i<n; i++)  { 
                  
                  List<Integer> al = new ArrayList<>();
                  // diagonal ele
                  for(int row = i, col = 0; row<n && col<n; row++,col++) {
                       al.add(grid[row][col]);
                  }

                  Collections.sort(al, Collections.reverseOrder());
                   int idx = 0;
                   for(int row = i, col = 0; row<n && col<n; row++,col++) {
                        grid[row][col] = al.get(idx++);
                   }
            } 


            // sort top diagonal in increasing order

            for(int j = 1; j<n; j++) {
                   List<Integer> al = new ArrayList<>();
                   for(int row = 0, col = j; row<n && col<n; row++, col++) {
                          al.add(grid[row][col]);
                   }


                   Collections.sort(al);
                   int idx = 0;
                   for(int row = 0, col = j; row<n && col<n; row++, col++) {
                          grid[row][col] = al.get(idx++);
                   }
            }     


            return grid;

    }
}