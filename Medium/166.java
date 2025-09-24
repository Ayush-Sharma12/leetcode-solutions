class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
          
           String sign = "";
           long num_ = numerator;
           long den_ = denominator;   
          
           if((num_ < 0 && den_ > 0) || (num_ > 0 && den_ < 0)){
               sign = "-";
           }    
          
           long num = Math.abs(num_);
           long den = Math.abs(den_);

           
            
           long r = num % den;
           long q = num / den; 
           StringBuilder sb = new StringBuilder();
           sb.append(q+"");

           if(r == 0) {
              return sign + sb.toString();
           }
          
           sb.append(".");
           Map<Long, Integer> map = new HashMap<>();
           while(r != 0) {
                if(map.containsKey(r)) {
                    sb.insert(map.get(r), "(");
                    sb.append(")");
                    return sign + sb.toString();
                }

                map.put(r, sb.length());

                num = r * 10;
                q = num / den;
                r = num % den;
                sb.append(q + "");  

           } 


           return sign + sb.toString();
     
    }
}