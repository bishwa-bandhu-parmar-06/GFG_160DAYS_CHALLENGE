// Sorted subsequence of size 3
// Difficulty: MediumAccuracy: 25.95%Submissions: 85K+Points: 4Average Time: 20m
// Given an array arr[], find any subsequence of three elements such that, arr[i] < arr[j] < arr[k] and (i < j < k).

// If such a subsequence exists, return the three elements as an array. Otherwise, return an empty array.

// Note:

// The driver code will print 1 if the returned subsequence is valid and present in the array.
// The driver code will print 0 if no such subsequence exists.
// If the returned subsequence does not satisfy the required format or conditions, the output will be -1.
// Examples :

// Input: arr[] = [12, 11, 10, 5, 6, 2, 30]
// Output: 1
// Explanation: As 5 < 6 < 30, and they  appear in the same sequence in the array. So output is 1.
// Input: arr[] = [1, 2, 3, 4]
// Output: 1 
// Explanation: As the array is sorted, for every i, j, k, where i < j < k, arr[i] < arr[j] < arr[k].So output is 1.
// Input: arr[] = [4, 3, 2, 1]
// Output: 0
// Explanation: No such Subsequence exist, so empty array is returned (the driver code automatically prints 0 in this case).
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 106


class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        // code here
        ArrayList<Integer> res=new ArrayList<Integer>();
        int n=arr.length;
        int[] smaller=new int[n];
        Arrays.fill(smaller,-1);
        int min=0;
        for(int i=1;i<n;i++)
        {
            if(arr[i]<arr[min])
            {
                min=i;
            }
            else
            {
                smaller[i]=min;
            }
        }
        int[] greater = new int[n];
        Arrays.fill(greater, -1);
        int max = n - 1;
        for (int i = n - 2; i >= 0; i--)
        {
            if (arr[i] >= arr[max])
                max = i;
            else
                greater[i] = max;
        }
        for (int i = 0; i < n; i++)
        {
            if (smaller[i] != -1 && greater[i] != -1){
            res.add(arr[smaller[i]]);
            res.add(arr[i]);
            res.add(arr[greater[i]]);
                return res;
            }
        }
        return res;
    }
}