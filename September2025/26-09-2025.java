// Rotate Deque By K
// Difficulty: EasyAccuracy: 75.79%Submissions: 16K+Points: 2
// You are given a deque dq[] (double-ended queue) containing non-negative integers, along with two positive integer type and k. The task is to rotate the deque circularly by k positions.
// There are two types of rotation operations:


// Right Rotation (Clockwise): If type = 1, rotate the deque to the right. This means moving the last element to the front, and repeating the process k times.

// Left Rotation (Anti-Clockwise): If type = 2, rotate the deque to the left. This means moving the first element to the back, and repeating the process k times.

// Examples:


class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        // code here
        int n = dq.size();
        k %= n;
        
        if (type == 1) {
            while (k-- != 0) {
                int ele = dq.pollLast();
                dq.offerFirst(ele);
            }
            
        }
        else if (type == 2) {
            while (k-- != 0) {
                int ele = dq.pollFirst();
                dq.offerLast(ele);
            }
            
        }
        return ;
    }
}