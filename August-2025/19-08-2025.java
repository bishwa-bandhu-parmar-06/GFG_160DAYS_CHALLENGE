// Farthest Smaller Right
// Difficulty: MediumAccuracy: 49.85%Submissions: 3K+Points: 4
// // You are given an array arr[]. For each element at index i (0-based indexing), find the farthest index j to the right (i.e., j > i) such that arr[j] < arr[i]. If no such index exists for a given position, return -1 for that index. Return the resulting array of answers.


class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        // Code Here
          int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        // store value and index
        ArrayList<int[]> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(new int[]{arr[i], i});
        }

        // sort by value
        v.sort((a, b) -> Integer.compare(a[0], b[0]));

        int maxi = v.get(0)[1];
        for (int i = 1; i < n; i++) {
            if (maxi > v.get(i)[1]) {
                ans.set(v.get(i)[1], maxi);
            }
            maxi = Math.max(maxi, v.get(i)[1]);
        }

        return ans;
    }
} 