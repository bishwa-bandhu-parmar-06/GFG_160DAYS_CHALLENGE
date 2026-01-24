// Josephus problem
// Difficulty: EasyAccuracy: 57.26%Submissions: 122K+Points: 2
// You are playing a game with n people standing in a circle, numbered from 1 to n. Starting from person 1, every kth person is eliminated in a circular fashion. The process continues until only one person remains.
// Given integers n and k, return the position (1-based index) of the person who will survive.


class Solution {
    public int josephus(int n, int k) {
        // code here
       int res = 0;
       
       for (int i = 2; i <= n; i++) {
            res = (res + k) % i;
        }

        return res + 1;
    }
}