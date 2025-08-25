// Time complexity: O(N*M)
//space complexity: O(N*M)

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        List<Integer> order = new ArrayList<>();

        int m = mat.length;
        int n = mat[0].length;

        int i = 0;
        boolean even = true;
        while (i < m) {

            List<Integer> diagonal = getDiagonal(mat, i, 0);

            if (!even) {
                Collections.reverse(diagonal);
                even = true;
            } else
                even = false;

            order.addAll(diagonal);
            i++;
        }

        int j = 1;
        while (j < n) {
            List<Integer> diagonal = getDiagonal(mat, m - 1, j);

            if (!even) {
                Collections.reverse(diagonal);
                even = true;
            }

            else
                even = false;

            order.addAll(diagonal);
            j++;
        }

        int[] ans = new int[order.size()];

        for (int t = 0; t < ans.length; t++) {
            ans[t] = order.get(t);
        }

        return ans;
    }

    private List<Integer> getDiagonal(int[][] mat, int row, int col) {

        List<Integer> temp = new ArrayList<>();
        int n = mat[0].length;
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            temp.add(mat[i][j]);
        }

        return temp;
    }
}