# Minimum Insert and Delete to Convert
# Difficulty: HardAccuracy: 27.85%Submissions: 19K+Points: 8Average Time: 30m
# Given two arrays a[] and b[] of size n and m respectively, find the minimum number of insertions and deletions on the array a[], required to make both the arrays identical.

# Note: Array b[] is sorted and all its elements are distinct, operations can be performed at any index not necessarily at the end.


class Solution:
     def minInsAndDel(self, a, b):
        from bisect import bisect_left
        n, m = len(a), len(b)
        b_set = set(b)
        lis = []
        for a_elem in a:
            if a_elem not in b_set:
                continue
            i = bisect_left(lis, a_elem)
            if i == len(lis):
                lis.append(a_elem)
            else:
                lis[i] = a_elem
        return n + m - 2 * len(lis)