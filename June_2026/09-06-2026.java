// Seating Arrangement
// Difficulty: EasyAccuracy: 49.85%Submissions: 51K+Points: 2
// Given an integer k representing the number of people to be seated and an array seats[], where 0 denotes an empty seat and 1 denotes an occupied seat.

// Determine whether it is possible to seat all k people such that no two occupied seats are adjacent (including newly seated people).

class Solution {
    public boolean canSeatAllPeople(int n, int[] seats) {

        for (int i = 0; i < seats.length; i++) {

            if (seats[i] == 0 &&
                (i == 0 || seats[i - 1] == 0) &&
                (i == seats.length - 1 || seats[i + 1] == 0)) {

                seats[i] = 1;
                n--;

                if (n == 0) return true;
            }
        }

        return n <= 0;
    }
}