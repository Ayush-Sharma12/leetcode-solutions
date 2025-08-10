class Solution {
    public boolean reorderedPowerOf2(int n) {
          
          char[] ch = String.valueOf(n).toCharArray();
          Arrays.sort(ch);
             
          String str = String.valueOf(ch);

          for(int i = 0; i<30; i++) {
               char[] chars = String.valueOf((int)Math.pow(2, i)).toCharArray();
               Arrays.sort(chars);

               if(new String(chars).equals(str)) {
                     return true;
               }    
          }    

          return false;   
    }
}