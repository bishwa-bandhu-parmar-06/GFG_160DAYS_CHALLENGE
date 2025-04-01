// Majority Element II
// Difficulty: Medium     Accuracy: 48.1%    Submissions: 79K+    Points: 4
// You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

// Note: The answer should be returned in an increasing format.

class Solution {
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        int n = nums.length;
        int one_third = n / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > one_third)
                res.add(key);
        }

        return res;
    }
}