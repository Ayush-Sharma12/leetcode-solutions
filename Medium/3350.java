// Time Complexity: O(N)
// Space Complexity: O(N)

/*
  i have used sliding window approach with a maximum size of k which is determined by inner while loop 
  along with that i have also maintained a prevLen pointer to checkout the adjacent subarray len
  which makes it easier identify the correct subarray, if the length of two adjacent array are not same
  then my algorithm select the minimum one among them, and also i keep a track of currlen to use its half len
  for possible k size. 
*/

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
           
            
             int n = nums.size();
           
             int maxK = 0;
             int prevLen = -1;
             int i = 0;
             while(i < n) {
                     int j = i+1;
                     
                     while(j < n && nums.get(j) > nums.get(j-1)) j++;
                     

                     int currLen = j - i;

                    
                     maxK = Math.max(maxK, currLen / 2); // possiblity, if curr len is much higher --->  then we can divide it to make two adjacent valid subarray
                     

                     if(prevLen != -1) {
                         maxK = Math.max(maxK, Math.min(currLen, prevLen)); // take minimum of two adjacent array if len are not same
                      }
                     
                     prevLen = currLen;
                     i = j; // move on for the next one
             }

             return maxK;
    }
}
