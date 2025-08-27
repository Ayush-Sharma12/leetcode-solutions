//time complexity: O(M*N)

class Solution {

    final private int[][] directions = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } }; // diagonal movement 

    public int lenOfVDiagonal(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int maxAns = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {

                    for (int d = 0; d < 4; d++) {
                        maxAns = Math.max(maxAns, 1 + dfs(grid, d, 1, i, j, 2));
                    }
                }
            }
        }

        return maxAns;
    }

    private int dfs(int[][] grid, int d, int canMove, int i, int j, int val) {

        int m = grid.length;
        int n = grid[0].length;

        int next_i = i + directions[d][0];
        int next_j = j + directions[d][1];

        if (next_i < 0 || next_j < 0 || next_i >= m || next_j >= n || grid[next_i][next_j] != val) {
            return 0;
        }

        int nextVal = (val == 2) ? 0 : 2;

        int move = 0;

        if (canMove == 1) {
            move = 1 + dfs(grid, (d + 1) % 4, 0, next_i, next_j, nextVal);
        }

        int forward = 1 + dfs(grid, d, canMove, next_i, next_j, nextVal);

        return Math.max(move, forward);

    }

}