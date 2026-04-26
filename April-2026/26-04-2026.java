// Common in 3 Sorted Arrays
// Difficulty: EasyAccuracy: 22.16%Submissions: 453K+Points: 2
// Given three sorted arrays in non-decreasing order, return all common elements in non-decreasing order across these arrays. If there are no such elements return an empty array.
// Note: Ignore duplicates, include each common element only once in the output.

// Examples :

// Input: a[] = [1, 5, 10, 20, 40, 80], b[] = [6, 7, 20, 80, 100], c[] = [3, 4, 15, 20, 30, 70, 80, 120]
// Output: [20, 80]
// Explanation: The elements 20 and 80 appear in all three arrays a, b, and c, making them the only common elements, so the output is [20, 80].
// Input: a[] = [1, 2, 3, 4, 5], b[] = [6, 7], c[] = [8, 9, 10]
// Output: []
// Explanation: Since none of the elements in arrays a, b, and c appear in all three arrays, there are no common elements, so the output is [].
// Input:  a[] = [1, 1, 1, 2, 2, 2], b[] = [1, 1, 2, 2, 2], c[] = [1, 1, 1, 1, 2, 2, 2, 2]
// Output: [1, 2]
// Explanation: Ignoring duplicates, 1 and 2 are present in all three arrays, so the output is [1, 2].


class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        int n = a.length ; 
        int m = b.length ; 
        int o = c.length ; 
        int i = 0 , j = 0 , k = 0 ; 
        ArrayList<Integer>list = new ArrayList<>();
        HashSet<Integer>hset = new HashSet<>();
        while(i<n && j<m && k<o)
        {
            int max = Math.max(a[i] ,Math.max(b[j] , c[k]));
            while(i < n && a[i] < max) i++;
            while(j < m && b[j] < max) j++;
            while(k < o && c[k] < max) k++;
            if(i>=n || j>=m || k>=o) break;
            if((a[i]==b[j]) && (b[j]==c[k])) 
            {
                if(!hset.contains(a[i])) 
                {
                    list.add(a[i]);
                    hset.add(a[i]);
                }
                i++;
                j++;
                k++;
            }
        }
        return list;
        
    }
}