// time complexity: O(N^2)
// space complexity: O(1)
class Solution {
    public int numberOfPairs(int[][] points) {

        int n = points.length;

        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return b[1] - a[1];
        });

        int count = 0;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int maxY = -1;
            for (int j = i + 1; j < n; j++) {
                int y2 = points[j][1];

                if (y2 <= y1 && maxY < y2) {
                    count++;
                    maxY = y2;
                }

            }
        }

        return count;
    }
}