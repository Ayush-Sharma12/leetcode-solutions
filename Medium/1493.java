// time complexity: O(N)
// Space Complexity : O(1)
class Solution {
    public int longestSubarray(int[] nums) {

        int ans = 0;

        int zeroIdx = -1;
        int i = 0;
        int j = 0;

        while (j < nums.length) {

            if (nums[j] == 0 && zeroIdx != -1) {
                ans = Math.max(ans, j - 1 - i);
                i = zeroIdx + 1;
                zeroIdx = j;

            } else if (nums[j] == 0) {
                zeroIdx = j;
            }
            j++;
        }

        return Math.max(ans, j - 1 - i); // in case of only one'1

    }
}