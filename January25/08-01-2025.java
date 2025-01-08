// Count the number of possible triangles
// Difficulty: MediumAccuracy: 28.53%Submissions: 125K+Points: 4
// Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. 

// A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.


class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int n = arr.length;

        // If there are fewer than 3 sides, no triangle can be formed.
        if (n < 3) return 0;

        // Sort the array in ascending order
        Arrays.sort(arr);

        int count = 0;

        // Fix the third side (largest side of the triangle)
        for (int k = n - 1; k >= 2; k--) {
            int i = 0; // Start pointer
            int j = k - 1; // End pointer before the largest side

            // Check pairs (i, j) such that arr[i] + arr[j] > arr[k]
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    // All pairs between i and j can form a triangle with arr[k]
                    count += (j - i);
                    j--; // Decrease j to check smaller pairs
                } else {
                    i++; // Increase i to increase the sum
                }
            }
        }

        return count;
    }
}