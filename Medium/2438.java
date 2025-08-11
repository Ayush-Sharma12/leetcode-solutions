class Solution {
    public int[] productQueries(int n, int[][] queries) {
           
            int mod = 1000000007;
            List<Integer> powers = new ArrayList<>();
            for(int i = 0; i<32; i++) {
                      
                  if((n & (1 << i)) != 0) { // bit set
                          powers.add(1 << i);                       
                  }
            } 


            int[] ans = new int[queries.length];
            int idx = 0;
            for(int[] query : queries) {
                   int left = query[0];
                   int right = query[1];

                   long prod = 1;
                   for(int pos = left; pos <= right; pos++) {
                          prod = (prod * powers.get(pos)) % mod;
                   }

                   ans[idx++] = (int)prod;
            }


            return ans;
    }
}