// Job Sequencing Problem
// Difficulty: MediumAccuracy: 34.51%Submissions: 291K+Points: 4
// You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

// Your task is to find:

// The maximum number of jobs that can be completed within their deadlines.
// The total maximum profit earned by completing those jobs.

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int[][] jobs = new int[n][2];

        // Store jobs with deadline and profit
        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadline[i];  // Deadline
            jobs[i][1] = profit[i];    // Profit
        }

        // Sort jobs based on profit in descending order
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);

        // Find the maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][0]);
        }

        // Array to keep track of free slots
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);  // -1 indicates slot is empty

        int countJobs = 0, maxProfit = 0;

        // Assign jobs greedily
        for (int i = 0; i < n; i++) {
            int d = jobs[i][0];
            int p = jobs[i][1];

            // Find the latest available slot before deadline
            for (int j = d; j > 0; j--) {
                if (slot[j] == -1) {
                    slot[j] = i;  // Assign job to this slot
                    countJobs++;
                    maxProfit += p;
                    break;
                }
            }
        }

        // Return the number of jobs done and total profit
        ArrayList<Integer> result = new ArrayList<>();
        result.add(countJobs);
        result.add(maxProfit);
        return result;
    }
}
