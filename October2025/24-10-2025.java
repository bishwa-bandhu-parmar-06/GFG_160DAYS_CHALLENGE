// Split Array Subsequences
// Difficulty: MediumAccuracy: 51.83%Submissions: 10K+Points: 4
// Given a sorted integer array arr[] and an integer k, determine if it is possible to split the array into one or more consecutive subsequences such that:

// Each subsequence consists of consecutive integers (each number is exactly one greater than the previous).
// Every subsequence has a length of at least k.
// Return true if such a split is possible, otherwise return false.



class Solution {
    public boolean isPossible(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        
    
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (count.get(num) == 0) 
            continue; 

            count.put(num, count.get(num) - 1);

            if (end.getOrDefault(num - 1, 0) > 0) {
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
            }
          
            else {
                boolean canForm = true;
                for (int i = 1; i < k; i++) {
                    if (count.getOrDefault(num + i, 0) <= 0) {
                        canForm = false;
                        break;
                    }
                }
                if (!canForm) return false;

                
                for (int i = 1; i < k; i++) {
                    count.put(num + i, count.get(num + i) - 1);
                }
                end.put(num + k - 1, end.getOrDefault(num + k - 1, 0) + 1);
            }
        }
        return true;
    }
}