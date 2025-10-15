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

                    
                     maxK = Math.max(maxK, currLen / 2);
                     

                     if(prevLen != -1) {
                         maxK = Math.max(maxK, Math.min(currLen, prevLen));
                      }
                     
                     prevLen = currLen;
                     i = j;
             }

             return maxK;
    }
}