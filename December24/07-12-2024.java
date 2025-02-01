<<<<<<< HEAD
// Count Inversions
// Difficulty: Medium    Accuracy: 16.93%      Submissions: 588K+          Points: 4
// Given an array of integers arr[]. Find the Inversion Count in the array.
// Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
// If an array is sorted in the reverse order then the inversion count is the maximum. 




class Solution {
    static int inversionCount(int arr[]) {
        return mergeSort(arr,0,arr.length-1);
    }
    
    private static int mergeSort(int[] arr,int left,int right){
        int count=0;
        if(left<right){
            int mid=left+(right-left)/2;
            count+=mergeSort(arr,left,mid);
            count+=mergeSort(arr,mid+1,right);
            count+=merge(arr,mid,left,right);
        }
        return count;
    }
    private static int merge(int[] arr,int mid,int left,int right){
        int l=left,r=mid+1;
        int count=0;
        ArrayList<Integer> temp=new ArrayList<>();
        while(l<=mid && r<=right){
            if(arr[l]<=arr[r]){
                temp.add(arr[l]);
                l++;
            }else{
                count+=(mid-l+1);
                temp.add(arr[r]);
                r++;
            }
        }
        while(l<=mid){
            temp.add(arr[l]);
            l++;
        }
        while(r<=right){
            temp.add(arr[r]);
            r++;
        }
        for(int i=left;i<=right;i++){
            arr[i]=temp.get(i-left);
        }
        return count;
    }
=======
// Count Inversions
// Difficulty: Medium    Accuracy: 16.93%      Submissions: 588K+          Points: 4
// Given an array of integers arr[]. Find the Inversion Count in the array.
// Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
// If an array is sorted in the reverse order then the inversion count is the maximum. 




class Solution {
    static int inversionCount(int arr[]) {
        return mergeSort(arr,0,arr.length-1);
    }
    
    private static int mergeSort(int[] arr,int left,int right){
        int count=0;
        if(left<right){
            int mid=left+(right-left)/2;
            count+=mergeSort(arr,left,mid);
            count+=mergeSort(arr,mid+1,right);
            count+=merge(arr,mid,left,right);
        }
        return count;
    }
    private static int merge(int[] arr,int mid,int left,int right){
        int l=left,r=mid+1;
        int count=0;
        ArrayList<Integer> temp=new ArrayList<>();
        while(l<=mid && r<=right){
            if(arr[l]<=arr[r]){
                temp.add(arr[l]);
                l++;
            }else{
                count+=(mid-l+1);
                temp.add(arr[r]);
                r++;
            }
        }
        while(l<=mid){
            temp.add(arr[l]);
            l++;
        }
        while(r<=right){
            temp.add(arr[r]);
            r++;
        }
        for(int i=left;i<=right;i++){
            arr[i]=temp.get(i-left);
        }
        return count;
    }
>>>>>>> e26a4c5eb349451cbceb0671410fab29a7d32069
}