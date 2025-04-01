// Stock span problem
// Difficulty: MediumAccuracy: 43.56%Submissions: 213K+Points: 4
// The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to calculate the span of stock price for all days. The span arr[i] of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.




class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        int[] span = new int[n]; // Use an integer array instead of ArrayList
        int[] stack = new int[n]; // Stack implemented as an array
        int top = -1; // Stack pointer

        for (int i = 0; i < n; i++) {
            while (top >= 0 && arr[stack[top]] <= arr[i]) {
                top--; // Pop elements from stack
            }

            // Calculate span
            span[i] = (top == -1) ? (i + 1) : (i - stack[top]);

            // Push index onto stack
            stack[++top] = i;
        }

        // Convert int[] to ArrayList<Integer>
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int value : span) {
            result.add(value);
        }
        
        return result;
    }
}