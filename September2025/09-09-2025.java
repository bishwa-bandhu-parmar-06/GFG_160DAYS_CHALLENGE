
// Assign Mice Holes
// Difficulty: EasyAccuracy: 55.93%Submissions: 18K+Points: 2
// You are given two arrays mices[] and holes[] of the same size. The array mices[] represents the positions of the mice on a straight line, while the array holes[] represents the positions of the holes on the same line. Each hole can accommodate exactly one mouse. A mouse can either stay in its current position, move one step to the right, or move one step to the left, and each move takes one minute. The task is to assign each mouse to a distinct hole in such a way that the time taken by the last mouse to reach its hole is minimized.













class Solution {
    public int assignHole(int[] mices, int[] holes) {
        // code here
       
        Arrays.sort(mices);
        Arrays.sort(holes);

        int n = mices.length;
        int maxTime = 0;

       
        for (int i = 0; i < n; i++) {
            maxTime = Math.max(maxTime, Math.abs(mices[i] - holes[i]));
        }

        return maxTime;
    }
};