class Solution {
    public long flowerGame(int n, int m) {

           long bigN = n;
           long bigM = m;   
            
           long case1 = ((bigN + 1) / 2) * (bigM/2);
           long case2 = (bigN/2) * ((bigM + 1) / 2);


           return case1 + case2;
    }
}