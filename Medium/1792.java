class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        int n = classes.length;   
        double[] passRatio = new double[n];

        int idx = 0;   
        Queue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        for(int[] cl : classes) {
               passRatio[idx] = (cl[0] * 1.0) / (cl[1] * 1.0); 

               double nextRatio = (cl[0] + 1) * 1.0 / (cl[1] + 1) * 1.0;

               maxHeap.offer(new double[]{idx, nextRatio - passRatio[idx]});
               idx++;   
         }  

        while(extraStudents-- > 0) {
                
                int classIdx = (int)maxHeap.poll()[0];

                classes[classIdx][0]++;
                classes[classIdx][1]++;  

                passRatio[classIdx] = classes[classIdx][0] * 1.0 / classes[classIdx][1] * 1.0; 
                double nextRatio = (classes[classIdx][0] + 1) * 1.0 / (classes[classIdx][1] + 1) * 1.0;


                maxHeap.offer(new double[]{classIdx, nextRatio - passRatio[classIdx]}); 
         }


         double sum = 0.0;
         for(double pr :  passRatio) {
                sum += pr;
         }


         return sum / n;
    }
}