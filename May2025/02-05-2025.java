// Bitonic Point
// Difficulty: EasyAccuracy: 58.67%Submissions: 145K+Points: 2Average Time: 15m
// Given an array of integers arr[] that is first strictly increasing and then maybe strictly decreasing, find the bitonic point, that is the maximum element in the array.
// Bitonic Point is a point before which elements are strictly increasing and after which elements are strictly decreasing.

// Note: It is guaranteed that the array contains exactly one bitonic point.

public int findMaximum(int[] arr) {
    // code here
    int start=1,end=arr.length-2;
    while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid+1]>arr[mid]) start=mid+1;
        else if(arr[mid-1]>arr[mid]) end=mid-1;
        else return arr[mid];
    }
    
    return Math.max(arr[0],arr[arr.length-1]);
}

