// Bus Conductor
// Difficulty: EasyAccuracy: 75.3%Submissions: 27K+Points: 2
// You are conductor of a bus. You are given two arrays chairs[] and passengers[] of equal length, where chairs[i] is the position of the ith chair and passengers[j] is the position of the jth passenger. You may perform the following move any number of times:

// Increase or decrease the position of the ith passenger by 1 (i.e., moving the ith passenger from position x to x+1 or x-1)
// Return the minimum number of moves required to move each passenger to get a chair.
// Note: Although multiple chairs can occupy the same position, each passenger must be assigned to exactly one unique chair.


class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        int result=0;
        for(int i=0;i<chairs.length;i++){
            result+=Math.abs(chairs[i]-passengers[i]);
        }
        return result;

    }
}
