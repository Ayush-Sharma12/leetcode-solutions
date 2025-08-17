class Solution {
    public double new21Game(int n, int k, int maxPts) {

            double[] dp = new double[k];
            Arrays.fill(dp, -1.0); 
            return f(n, k, maxPts, 0, dp);     
    }

    private double f(int n, int k, int maxPts, int start, double[] dp) {
             
             if(start >= k) {
                   if(start <= n) {
                       return 1;
                   }

                   return 0;
             } 
             
             if(dp[start] != -1.0) {
                  return dp[start];
             } 
             double totalPoints = 0.0;   
             for(int i = 1; i<=maxPts; i++) {
                  totalPoints += f(n, k, maxPts, start + i, dp);
             }


             return dp[start] = totalPoints/maxPts;
    }
}