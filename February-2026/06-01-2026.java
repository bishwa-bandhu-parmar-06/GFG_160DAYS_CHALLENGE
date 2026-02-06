// Happiest Triplet
// Difficulty: MediumAccuracy: 57.17%Submissions: 10K+Points: 4Average Time: 35m
// You are given three arrays a[], b[], c[] of the same size . Find a triplet such that (maximum-minimum) in that triplet is the minimum of all the triplets. A triplet should be selected so that it should have one number from each of the three given arrays. This triplet is the happiest among all the possible triplets. Print the triplet in decreasing order.

// Note: If there are 2 or more smallest difference triplets, then the one with the smallest sum of its elements should be displayed.



import java.util.*;

class Solution {
    int[] smallestDiff(int[] a, int[] b, int[] c) {

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;
        int best = Integer.MAX_VALUE;

        int[] ans = new int[3];

        while (i < a.length && j < b.length && k < c.length) {

            int x = a[i], y = b[j], z = c[k];

            int mx = Math.max(x, Math.max(y, z));
            int mn = Math.min(x, Math.min(y, z));

            if (mx - mn < best) {
                best = mx - mn;
                ans[0] = x;
                ans[1] = y;
                ans[2] = z;
            }

            if (mn == x) i++;
            else if (mn == y) j++;
            else k++;
        }

        Arrays.sort(ans);
        for (int l = 0, r = 2; l < r; l++, r--) {
            int tmp = ans[l];
            ans[l] = ans[r];
            ans[r] = tmp;
        }

        return ans;
    }
}