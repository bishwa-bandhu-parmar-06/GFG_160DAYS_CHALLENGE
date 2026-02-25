// Union of Arrays with Duplicates
// Difficulty: EasyAccuracy: 42.22%Submissions: 485K+Points: 2Average Time: 10m
// You are given two arrays a[] and b[], return the Union of both the arrays in any order.

// The Union of two arrays is a collection of all distinct elements present in either of the arrays. If an element appears more than once in one or both arrays, it should be included only once in the result.

// Note: Elements of a[] and b[] are not necessarily distinct.
// Note that, You can return the Union in any order but the driver code will print the result in sorted order only.


class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
       ArrayList<Integer> list = new ArrayList<>();
       Set<Integer> set = new HashSet<>();
       for(int x : a) set.add(x);
       for(int x : b) set.add(x);
       for(int x : set) list.add(x);
       return list;
    }
}