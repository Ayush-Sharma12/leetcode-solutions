class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {

         int n = nums.length;   
         Stack<Integer> st = new Stack<>();

         for(int i = 0; i<nums.length; i++) {
               if(st.isEmpty() || gcd(st.peek(), nums[i]) == 1) {
                          st.push(nums[i]);
                          continue;
               }
               
               int lcm = lcm(st.pop(), nums[i]);
               while(!st.isEmpty() && gcd(st.peek(), lcm) > 1) {
                      lcm = lcm(st.pop(), lcm);
               }

               st.push(lcm);
         }
         
         return new ArrayList<>(st);     
    
    } 


    private int gcd(long a, long b) {
            
              while(a != 0 && b != 0)  {
                   if(a > b) a %= b;
                   else b %= a;

              }


              if(a != 0) return (int)a;

              return (int)b;

    } 

    private int lcm(long a, long b) {
          return (int)((a * b) / gcd(a, b));
    }
}