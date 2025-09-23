class Solution {
    public int compareVersion(String version1, String version2) {
          
             String[] v1 =  version1.split("\\.");
             String[] v2 =  version2.split("\\.");   
             
             
             if(v1.length == v2.length) {
                   return compare(v1, v2, v1.length);
             }
             else if(v1.length < v2.length) {
                  int res = compare(v1, v2, v1.length);
                  
                  if(res != 0)  return res;

                  for(int i = v1.length; i<v2.length; i++) {
                       if(Integer.parseInt(v2[i]) > 0) return -1;
                  }


                  return 0;
             }else{

                 int res = compare(v1, v2, v2.length);
                 if(res != 0) return res;
               
                 for(int i = v2.length; i<v1.length; i++) {
                       if(Integer.parseInt(v1[i]) > 0) return 1;
                 }

                 return 0;
             }


      }

      private int compare(String[] v1, String[] v2, int len){
              
              for(int i = 0; i<len; i++) {
                     int rev1 = Integer.parseInt(v1[i]);
                     int rev2 = Integer.parseInt(v2[i]);


                     if(rev1 < rev2) return -1;

                     else if(rev1 > rev2) return 1;
              }


              return 0;
      }
}