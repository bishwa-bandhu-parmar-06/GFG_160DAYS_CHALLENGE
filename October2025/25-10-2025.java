// Minimum Steps to Halve Sum
// Difficulty: MediumAccuracy: 57.08%Submissions: 10K+Points: 4
// Given an array arr[], find the minimum number of operations required to make the sum of its elements less than or equal to half of the original sum. In one operation, you may replace any element with half of its value (with floating-point precision).


class Solution {
    public int minOperations(int[] arr) {
       PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for (int num : arr) {
            pq.offer((double) num);
            sum += num;
        }

        double target = sum / 2;
        double currSum = sum;
        int ops = 0;

        while (currSum > target) {
            double max = pq.poll();      
            double half = max / 2.0;     
            currSum -= (max - half);     
            pq.offer(half);               
            ops++;
        }

        return ops;
    }
}