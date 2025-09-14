class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
           
          int n = queries.length;
          String[] ans = new String[n];
          
          List<String> actualList = new ArrayList<>();
          Map<String, String> capitalizationMap = new HashMap<>();
          Map<String, String> vowelMap = new HashMap<>();
       
          for(int i = 0; i<wordlist.length; i++) {
               actualList.add(wordlist[i]);

             
               if(!capitalizationMap.containsKey(wordlist[i].toLowerCase())) {
                   capitalizationMap.put(wordlist[i].toLowerCase(), wordlist[i]);
               }

               String vowelStr = getVowelStr(wordlist[i]); 
                  
               if(!vowelMap.containsKey(vowelStr)) {
                    vowelMap.put(vowelStr, wordlist[i]);
               }
          }   
         
          int idx = 0; 
          for(String queryStr : queries) {
                
                if(actualList.indexOf(queryStr) != -1) {
                       ans[idx++] = queryStr;
                       continue;
                }
              
                if(capitalizationMap.containsKey(queryStr.toLowerCase())) {
                        ans[idx++] = capitalizationMap.get(queryStr.toLowerCase());
                        continue;
                }

                String vowelStr = getVowelStr(queryStr);   
                if(vowelMap.containsKey(vowelStr)){
                        ans[idx++] = vowelMap.get(vowelStr);
                        continue;
                }
                
                
                ans[idx++] = "";
            
       }  

          return ans;
    }

   
   

   private String getVowelStr(String str) {
            
               char[] ch = str.toLowerCase().toCharArray();
               for(int i = 0; i<ch.length; i++) {
                    if("aeiou".contains(ch[i]+"")) {
                          ch[i] = '*';
                    }
               }  

            return String.valueOf(ch);
   }

    
}