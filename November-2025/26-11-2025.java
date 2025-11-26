// AND In Range
// Difficulty: MediumAccuracy: 33.68%Submissions: 4K+Points: 4
// // You are given two integers l and r. Find the result after applying the series of Bitwise AND ( & ) operation on every natural number between the range l to r (including both).



class Solution {

    public int andInRange(int l, int r) {

        int shift = 0;

 

        // find common prefix

        while (l < r) {

            l >>= 1;

            r >>= 1;

            shift++;

        }

 

        // restore shifted bits

        return l << shift;

    }

}