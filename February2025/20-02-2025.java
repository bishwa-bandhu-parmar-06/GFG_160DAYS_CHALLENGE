// Find median in a stream
// Difficulty: HardAccuracy: 30.34%Submissions: 137K+Points: 8Average Time: 45m
// Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.

// There are two cases for median on the basis of data set size.

// 1. If the data set has an odd number then the middle one will be consider as median.
// 2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.

class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min heap for larger half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max heap for smaller half
        
        for (int num : arr) {
            // Step 1: Insert into appropriate heap
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            
            // Step 2: Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            
            // Step 3: Find the median
            if (maxHeap.size() > minHeap.size()) {
                result.add((double) maxHeap.peek());
            } else {
                result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
        }
        return result;
    }
}
