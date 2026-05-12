// Range LCM Queries
// Difficulty: MediumAccuracy: 52.98%Submissions: 11K+Points: 4Average Time: 45m
// Given an array arr[]  and a list of queries queries[][]. Each query can be one of the following two types:

// Update Query: [1, index, value] --> Update the element at position index in the array to the given value.
// Range Query: [2, L, R] --> Compute and return the Least Common Multiple (LCM) of all elements in the subarray from index L to R (inclusive).
// Process all queries sequentially and return a list containing the results of all Type 2 queries.

// Note: All operations follow 0-based indexing.

// Examples :

// Input: arr[] = [2, 3, 4, 6, 8, 16], queries[][] = [[2, 0, 2], [1, 3, 8], [2, 2, 5]]
// Output: [12, 16]
// Explanation: The queries are processed sequentially, updating the array when required.
// [2, 0, 2]: LCM of [2, 3, 4] = 12
// [1, 3, 8]: array becomes [2, 3, 4, 8, 8, 16]
// [2, 2, 5]: LCM of [4, 8, 8, 16] = 16
// Input: arr[] = [1, 2, 3, 4],  queries[][] = [[2, 0, 3], [1, 0, 5], [2, 0, 1]]
// Output: [12, 10]
// Explanation: The queries are processed sequentially, updating the array when required.
// [2, 0, 3]: LCM of [1, 2, 3, 4] = 12
// [1, 0, 5]: array becomes [5, 2, 3, 4]
// [2, 0, 1]: LCM of [5, 2] = 10
// Constraints:
// 1 ≤ arr.size() ≤ 104
// 1 ≤ queries.size() ≤ 105
// 0 ≤ L ≤ R ≤ arr.size() - 1
// 0 ≤ index ≤ arr.size() - 1
// 1 ≤ arr[i], value ≤ 104




import java.util.*;

class Solution {
    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        SegmentTree st = new SegmentTree(arr);
        ArrayList<Long> result = new ArrayList<>();
        
        for (int[] q : queries) {
            if (q[0] == 1) {
                // Update query
                st.update(q[1], q[2], 0, arr.length - 1, 1);
            } else {
                // Range query
                result.add(st.query(q[1], q[2], 0, arr.length - 1, 1));
            }
        }
        return result;
    }
}

class SegmentTree {
    int n;
    long[] tree;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new long[4 * n];
        build(arr, 0, n - 1, 1);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return Math.max(a, b);
        return (a / gcd(a, b)) * b;
    }

    private void build(int[] arr, int l, int r, int idx) {
        if (l == r) {
            tree[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, l, mid, 2 * idx);
        build(arr, mid + 1, r, 2 * idx + 1);
        tree[idx] = lcm(tree[2 * idx], tree[2 * idx + 1]);
    }

    public void update(int pos, int val, int l, int r, int idx) {
        if (l == r) {
            tree[idx] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) update(pos, val, l, mid, 2 * idx);
        else update(pos, val, mid + 1, r, 2 * idx + 1);
        tree[idx] = lcm(tree[2 * idx], tree[2 * idx + 1]);
    }

    public long query(int ql, int qr, int l, int r, int idx) {
        if (qr < l || ql > r) return 1; // neutral element for LCM
        if (ql <= l && r <= qr) return tree[idx];
        int mid = (l + r) / 2;
        long left = query(ql, qr, l, mid, 2 * idx);
        long right = query(ql, qr, mid + 1, r, 2 * idx + 1);
        return lcm(left, right);
    }
}