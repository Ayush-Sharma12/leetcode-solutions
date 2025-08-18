class Solution {
    public boolean judgePoint24(int[] cards) {

           List<Double> list = new ArrayList<>();
           for(int card : cards) {
              list.add((double)card);
           }            

           return is24(list);
    }  


    private boolean is24(List<Double> nums) {

           int n = nums.size(); 
           //base case
           if(n == 1) {
                return Math.abs((nums.get(0) - 24.0)) < 0.000001;
           }   


           for(int i = 0; i<n-1; i++) {
              for(int j = i+1; j<n; j++) {
                     
                     double a = nums.get(i);
                     double b = nums.get(j);

                     List<Double> opr = allOpr(a, b);

                     List<Double> newOrder = new ArrayList<>();
                     for(int k = 0; k<n; k++) {
                         
                         if(k != i && k != j)
                           newOrder.add(nums.get(k));
                     }   


                     for(double op : opr) {
                           newOrder.add(op);

                           if(is24(newOrder)) {
                               return true;
                           }

                           newOrder.remove(newOrder.size()-1);
                     }
              }
           }  

           return false;
    }

    private List<Double> allOpr(double a, double b ) {
           
           List<Double> opr = new ArrayList<>();
           opr.add(a + b);
           opr.add(a - b);
           opr.add(b - a);
           opr.add(a * b);
           opr.add(a / b);
           opr.add(b / a);

           return opr;
    }
}