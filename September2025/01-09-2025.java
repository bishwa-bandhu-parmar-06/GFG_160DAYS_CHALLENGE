// Sum of Mode
// Difficulty: HardAccuracy: 61.55%Submissions: 8K+Points: 8Average Time: 20m
// Given an array arr[] of positive integers and an integer k. You have to find the sum of the modes of all the subarrays of size k.
// Note: The mode of a subarray is the element that occurs with the highest frequency. If multiple elements have the same highest frequency, the smallest such element is considered the mode.


class Solution {
    public int sumOfModes(int[] arr, int k) {
        // code here
      
        int n = arr.length;
        
      
        Map<Integer, Integer> freq = new HashMap<>();
        
        
        TreeMap<Integer, TreeSet<Integer>> bucket = new TreeMap<>();
        
        
        Runnable updateMode = () -> {}; 

        RunnableAdder adder = (x) -> {
            int oldFreq = freq.getOrDefault(x, 0);
            int newFreq = oldFreq + 1;
            
            freq.put(x, newFreq);
            
           
            if (oldFreq > 0) {
                TreeSet<Integer> set = bucket.get(oldFreq);
                set.remove(x);
                if (set.isEmpty()) bucket.remove(oldFreq);
            }
            
           
            bucket.computeIfAbsent(newFreq, f -> new TreeSet<>()).add(x);
        };
        
      
        RunnableRemover remover = (x) -> {
            int oldFreq = freq.get(x);
            int newFreq = oldFreq - 1;
            
           
            TreeSet<Integer> set = bucket.get(oldFreq);
            set.remove(x);
            if (set.isEmpty()) bucket.remove(oldFreq);
            
            if (newFreq == 0) {
                freq.remove(x);
            } else {
                freq.put(x, newFreq);
                bucket.computeIfAbsent(newFreq, f -> new TreeSet<>()).add(x);
            }
        };
        
        int result = 0;
        
   
        for (int i = 0; i < k; i++) {
            adder.add(arr[i]);
        }
        result += bucket.lastEntry().getValue().first(); 
        
        
        for (int i = k; i < n; i++) {
            adder.add(arr[i]);         
            remover.remove(arr[i - k]); 
            result += bucket.lastEntry().getValue().first(); 
        }
        
        return result;
    }
    
    
    interface RunnableAdder {
        void add(int x);
    }
    interface RunnableRemover {
        void remove(int x);
    }

}