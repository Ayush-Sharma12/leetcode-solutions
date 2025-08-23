
// Time Complexity: O(N^4) in worst case
// Space Complexity: O(N^2)
class Solution {
    public int minimumSum(int[][] grid) {

        int case1 = ans(grid);

        int case2 = ans(rotatedGrid(grid));

        return Math.min(case1, case2);

    }

    private int[][] rotatedGrid(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] newGrid = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newGrid[j][i] = grid[i][j];
            }
        }

        return newGrid;
    }

    private int ans(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // case 1
        int ans = Integer.MAX_VALUE;
        for (int startRow = 1; startRow < m; startRow++) {
            for (int startCol = 1; startCol < n; startCol++) {

                int topLeft = minArea(grid, 0, startRow, 0, startCol);
                int topRight = minArea(grid, 0, startRow, startCol, n);
                int bottom = minArea(grid, startRow, m, 0, n);

                ans = Math.min(ans, topLeft + topRight + bottom);

                int top = minArea(grid, 0, startRow, 0, n);
                int bottomLeft = minArea(grid, startRow, m, 0, startCol);
                int bottomRight = minArea(grid, startRow, m, startCol, n);

                ans = Math.min(ans, top + bottomLeft + bottomRight);

            }

        }
        // horizontal split
        for (int rowSplit1 = 1; rowSplit1 < m - 1; rowSplit1++) {
            for (int rowSplit2 = rowSplit1 + 1; rowSplit2 < m; rowSplit2++) {
                int top = minArea(grid, 0, rowSplit1, 0, n);
                int mid = minArea(grid, rowSplit1, rowSplit2, 0, n);
                int bottom = minArea(grid, rowSplit2, m, 0, n);

                ans = Math.min(ans, top + mid + bottom);
            }
        }

        
        return ans;
    }

    private int minArea(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {

        // top to bottom

        int len1 = -1;
        for (int i = rowStart; i < rowEnd; i++) {
            boolean flag = false;
            for (int j = colStart; j < colEnd; j++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    len1 = i;
                    break;
                }

            }

            if (flag)
                break;
        }

        // bottom to up  
        int len2 = -1;
        for (int i = rowEnd - 1; i >= 0; i--) {

            boolean flag = false;
            for (int j = colStart; j < colEnd; j++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    len2 = i;
                    break;
                }

            }

            if (flag)
                break;

        }

        // left to right
        int breadth1 = -1;
        for (int j = colStart; j < colEnd; j++) {
            boolean flag = false;
            for (int i = rowStart; i < rowEnd; i++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    breadth1 = j;
                    break;
                }
            }

            if (flag)
                break;
        }

        // right to left
        int breadth2 = -1;
        for (int j = colEnd - 1; j >= 0; j--) {
            boolean flag = false;
            for (int i = rowStart; i < rowEnd; i++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    breadth2 = j;
                    break;
                }
            }

            if (flag)
                break;
        }

        int len = len2 - len1 + 1;
        int width = breadth2 - breadth1 + 1;

        return len * width;
    }
}