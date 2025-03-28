// Activity Selection
// Difficulty: MediumAccuracy: 36.21%Submissions: 157K+Points: 4Average Time: 20m
// You are given a set of activities, each with a start time and a finish time, represented by the arrays start[] and finish[], respectively. A single person can perform only one activity at a time, meaning no two activities can overlap. Your task is to determine the maximum number of activities that a person can complete in a day.





class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int[][] activities = new int[n][2];

        // Store activities as pairs of (start, finish)
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }

        // Sort activities by their finish time
        Arrays.sort(activities, (a, b) -> a[1] - b[1]);

        // Initialize count of selected activities
        int count = 1;  
        int lastFinish = activities[0][1];

        // Iterate through activities
        for (int i = 1; i < n; i++) {
            if (activities[i][0] > lastFinish) {
                count++;
                lastFinish = activities[i][1];
            }
        }
        
        return count;
    }
}
