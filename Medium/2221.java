class Solution {
    public int triangularSum(int[] nums) {

          int n = nums.length; 
          
          if(n == 1) {
              return nums[0];
          }  

          int[] newNums = new int[n-1];
          for(int i = 0; i<newNums.length; i++) {
               newNums[i] = (nums[i] + nums[i+1]) % 10;
          }

          return triangularSum(newNums);
    }
}