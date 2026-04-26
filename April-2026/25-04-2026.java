// Opposite Sign Pair Reduction
// Difficulty: MediumAccuracy: 50.06%Submissions: 58K+Points: 4Average Time: 30m
// Given an array arr[] , return the final array by repeatedly apply the following operation from left to right until no more valid operations can be performed.

// If two adjacent elements have opposite signs:

// If their absolute values are different, remove both elements and insert the one with the greater absolute value, preserving its sign.
// If their absolute values are equal, remove both elements without inserting any new element.



class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int length = arr.length;
        if (length == 1) {
            result.add(arr[0]);
            return result;
        }
        Stack<Integer> previousValue = new Stack<>(); // O(N)
        // O(N)
        for (int num : arr) {
            boolean numSurvives = true;
            while (!previousValue.isEmpty() && isSignOpposite(num, previousValue.peek())) {
                int topOfStack = previousValue.peek();
                int absNum = Math.abs(num);
                int absTopOfStack = Math.abs(topOfStack);
                if (absNum > absTopOfStack) {
                    previousValue.pop();
                }
                else if (absTopOfStack > absNum) {
                    numSurvives = false;
                    break;
                }
                else if (absTopOfStack == absNum) {
                    numSurvives = false;
                    previousValue.pop();
                    break;
                }
            }
            if (numSurvives) {
                previousValue.push(num);
            }
        }
        while (!previousValue.isEmpty()) {
            result.add(previousValue.pop());
        }
        Collections.reverse(result);
        return result;
    }
    
    private boolean isSignOpposite(int num1, int num2) {
        return (num1 >= 0 && num2 < 0) || (num1 < 0 && num2 >= 0);
    }
}