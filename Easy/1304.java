class Solution {
    public int[] sumZero(int n) {
           
          int[] ans = new int[n];

          int idx = 0; 
          for(int num = 1; num <= n/2; num++) {
               ans[2*idx] = num;
               ans[2*idx+1] = -num;

               idx++;
          } 

         return ans;  
    }
}