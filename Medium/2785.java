class Solution {
    public String sortVowels(String s) {
         
           List<Integer> idxList = new ArrayList<>();

           String vowel = "aeiouAEIOU";

           char[] ch = s.toCharArray(); 
           int n = ch.length;
           
           for(int i = 0; i<n; i++) {
                  if(vowel.contains(ch[i]+"")) {
                        idxList.add(i);
                        ch[i] = '#';
                  }
           }


           Collections.sort(idxList, (idx1, idx2) -> s.charAt(idx1) - s.charAt(idx2));

           int idx = 0;

           for(int i = 0; i<n; i++) {
                 if(ch[i] == '#') {
                       ch[i] = s.charAt(idxList.get(idx++));
                 }
           }


           return String.valueOf(ch);



    }
}