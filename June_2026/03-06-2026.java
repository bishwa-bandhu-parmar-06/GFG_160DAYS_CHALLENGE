// Subarray Frequency Count Queries
// Difficulty: MediumAccuracy: 59.5%Submissions: 11K+Points: 4Average Time: 25m
// Given an array arr[] of n integers and a 2D array queries[][] representing q queries, where each queries[i] consists of three integers: l, r, and x. For each query determine how many times the element x appears in the arr[] from index l to r (both inclusive).

// Return a list of integers where the i-th value represents the answer to the i-th query.

// Examples: 

// Input: arr[] = [1, 2, 1, 3, 1, 2, 3], queries[][] = [[0, 4, 1], [2, 5, 2], [1, 6, 3], [0, 6, 5]]
// Output: [3, 1, 2, 0]
// Explanation:
// query [0, 4, 1] -> Subarray = [1, 2, 1, 3, 1], 1 appears 3 times
// query [2, 5, 2] -> Subarray = [1, 3, 1, 2], 2 appears 1 time
// query [1, 6, 3] -> Subarray = [2, 1, 3, 1, 2, 3] 3 appears 2 times
// query [0, 6, 5] -> Subarray = [1, 2, 1, 3, 1, 2, 3],  5 appears 0 times


class Solution {
    
    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {

        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            mp.putIfAbsent(arr[i], new ArrayList<>());
            mp.get(arr[i]).add(i);
        }

        for (int[] q : queries) {
            int start = q[0];
            int end = q[1];
            int target = q[2];

            if (!mp.containsKey(target) || mp.get(target).get(0) > end) {
                res.add(0);
                continue;
            }

            List<Integer> indices = mp.get(target);

            int left = lowerBound(indices, start);
            int right = lowerBound(indices, end + 1);

            res.add(right - left);
        }

        return res;
    }
}