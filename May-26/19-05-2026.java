// Minimum Multiplications to reach End
// Difficulty: MediumAccuracy: 48.94%Submissions: 203K+Points: 4Average Time: 20m
// Given two integers, start and end, along with an array of integers arr[]. In one operation, you can multiply the current value by any element from arr[], and then take the result modulo 1000 to obtain a new value.

// Find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

// Examples :

// Input: arr[] = [2, 5, 7], start = 3, end = 30
// Output: 2
// Explanation:
// Step 1: 3*2 = 6 % 1000 = 6 
// Step 2: 6*5 = 30 % 1000 = 30
// Input: arr[] = [3, 4, 65], start = 7, end = 175
// Output: 4
// Explanation:
// Step 1: 7 * 3 = 21 % 1000 = 21  
// Step 2: 21 * 3 = 63 % 1000 = 63  
// Step 3: 63 * 65 = 4095 % 1000 = 95  
// Step 4: 95 * 65 = 6175 % 1000 = 175 
// Input: arr[] = [2, 4], start = 3, end = 5
// Output: -1
// Explanation: Starting from 3 and multiplying by 2 or 4 always produces even numbers after the first step. Since 5 is odd, it can never be reached.
// Constraints:
// 1  ≤ arr.size()  ≤ 103
// 1  ≤ arr[i]  ≤ 103
// 0  ≤ start, end  ≤ 103



import java.util.*;

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // If already at end
        if (start == end) return 0;

        // Queue for BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        // Visited array to avoid cycles
        boolean[] visited = new boolean[1000];
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int value = curr[0];
            int steps = curr[1];

            for (int num : arr) {
                int next = (value * num) % 1000;
                if (!visited[next]) {
                    if (next == end) return steps + 1;
                    visited[next] = true;
                    q.add(new int[]{next, steps + 1});
                }
            }
        }
        return -1; // Not reachable
    }
}