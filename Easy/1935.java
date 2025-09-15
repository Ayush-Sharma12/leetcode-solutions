class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
               

            String[] words = text.split(" ");
            int brokenWords = 0;
            for(String word : words) {

                   for(char ch : brokenLetters.toCharArray()) {
                           if(word.contains(ch+"")) {
                               brokenWords++;
                               break;
                           }
                   }         
            }       


            return words.length - brokenWords;
                 
    }
}