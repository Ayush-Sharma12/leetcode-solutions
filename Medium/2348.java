class Solution {
    public long zeroFilledSubarray(int[] nums) {
           

            long totalSubArray = 0; 
            long count = 0;
            for(int num : nums) {
                  if(num == 0) {
                       count++;
                  }else{
                      totalSubArray += (count * (count + 1))/2;
                      count = 0;
                  }
            }
             
           totalSubArray += (count * (count + 1))/2; 

            return totalSubArray;
    }
}