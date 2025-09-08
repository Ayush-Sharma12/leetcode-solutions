class Solution {
    public int[] getNoZeroIntegers(int n) {
           
           int first = -1;
           int sec = -1;
           for(int a = 1; a < n; a++) {
                int b = n - a;

                if(nonZero(a) && nonZero(b)) {
                       first = a;
                       sec = b;
                       break;
                }
           }


           return new int[]{first, sec};  
    }

    private boolean nonZero(int num) {
          
           while(num > 0) {
              if(num % 10 == 0) {
                  return false;
              }
              num /= 10;
           }

           return true;
    }
}