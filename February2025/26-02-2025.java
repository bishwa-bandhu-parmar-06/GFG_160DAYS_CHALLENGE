// Maximum of minimum for every window size
// Difficulty: HardAccuracy: 42.9%Submissions: 56K+Points: 8Average Time: 45m
// Given an array of integers arr[], the task is to find the maximum of the minimum values for every possible window size in the array, where the window size ranges from 1 to arr.size().

// More formally, for each window size k, determine the smallest element in all windows of size k, and then find the largest value among these minimums where 1<=k<=arr.size().


class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n + 1]; // Store the max of minimums for each window size

        // Step 1: Compute previous smaller elements using a stack
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // Step 2: Compute next smaller elements using a stack
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Step 3: Compute the maximum of minimums for each window size
        for (int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1;
            ans[windowSize] = Math.max(ans[windowSize], arr[i]);
        }

        // Step 4: Fill the unfilled entries in ans[]
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        // Convert result to ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(ans[i]);
        }
        
        return result;
    }
}
