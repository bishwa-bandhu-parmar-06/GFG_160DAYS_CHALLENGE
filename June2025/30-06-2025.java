// Max min Height
// Difficulty: HardAccuracy: 62.86%Submissions: 24K+Points: 8
// Given a garden with n flowers planted in a row, that is represented by an array arr[], where arr[i] denotes the height of the ith flower.You will water them for k days. In one day you can water w continuous flowers. Whenever you water a flower its height increases by 1 unit. You have to maximize the minimum height of all flowers after  k days of watering.


class Solution {
    public static boolean isPossible(int[] arr, int n, int k, int w, int target) {
        int[] diff = new int[n + 1];
        long used = 0;
        int add = 0;

        for (int i = 0; i < n; i++) {
            add += diff[i];
            int currHeight = arr[i] + add;

            if (currHeight < target) {
                int need = target - currHeight;
                used += need;
                if (used > k) return false;

                add += need;
                if (i + w < n) {
                    diff[i + w] -= need;
                }
            }
        }

        return true;
    }

    public static int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Integer.MAX_VALUE;
        int high = 0;

        for (int height : arr) {
            low = Math.min(low, height);
            high = Math.max(high, height);
        }

        high += k;
        int answer = low;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, n, k, w, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
}