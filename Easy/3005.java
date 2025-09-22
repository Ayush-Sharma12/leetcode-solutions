class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        int[] freqs = new int[101];

        for(int num : nums) freqs[num]++;

        int getMaxFreq = -1;
        for(int freq : freqs) {
               getMaxFreq = Math.max(getMaxFreq, freq);
        }  

        int occurencesOfMax = 0;

        for(int freq : freqs) {
               if(freq == getMaxFreq) occurencesOfMax++;
        } 


        return getMaxFreq * occurencesOfMax;
          
    }
}