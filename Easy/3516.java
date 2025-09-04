//Time complexity: O(1)
//Space complexity: O(1)
class Solution {
    public int findClosest(int x, int y, int z) {
          
           int distOfPerson1 = Math.abs(x - z);

           int distOfPerson2 = Math.abs(y - z);

           if(distOfPerson1 == distOfPerson2) {
               return 0;
           }   
           else if(distOfPerson1 < distOfPerson2) {
                 return 1;
           }else{
              return 2;
           }
    }
}
