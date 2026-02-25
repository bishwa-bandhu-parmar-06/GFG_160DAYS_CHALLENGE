// Count Inversions
// Difficulty: MediumAccuracy: 16.93%Submissions: 749K+Points: 4
// Given an array of integers arr[]. You have to find the Inversion Count of the array. 
// Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].


class Solution {
    static int inversionCount(int arr[]) {
        int n=arr.length;
        int cnt=0;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i=0;i<n;i++) {
            int l=0, h=al.size()-1;
            while(l<=h) {
                int mid = (l+h)/2;
                if (al.get(mid) <= arr[i]) {
                    l = mid+1;
                } else {
                    h = mid-1;
                }
            }
            cnt += (al.size()-l);
            al.add(l, arr[i]);
        }
        return cnt;
    }

}