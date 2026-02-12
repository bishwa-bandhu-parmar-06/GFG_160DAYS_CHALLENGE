// Max min Height
// Difficulty: HardAccuracy: 62.86%Submissions: 32K+Points: 8
// Given a garden with n flowers planted in a row, that is represented by an array arr[], where arr[i] denotes the height of the ith flower.You will water them for k days. In one day you can water w continuous flowers. Whenever you water a flower its height increases by 1 unit. You have to maximize the minimum height of all flowers after  k days of watering.



class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        // code here
        int n = arr.length;
        int low = Arrays.stream(arr).min().getAsInt();
        int high = low + k;
        int result = low;
        
        while(low <= high){
            int mid = (low + high) / 2;
            if(canAchieve(arr, k, w, mid)){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canAchieve(int[] arr, int k, int w, int target){
        int n = arr.length;
        int[] water = new int[n + 1];
        int ops = 0, currWater = 0;
        
        for(int i=0; i<n; i++){
            currWater += water[i];
            int height = arr[i] + currWater;
            if(height < target){
                int need = target - height;
                ops += need;
                if(ops > k) return false;
                currWater += need;
                if(i + w < n) water[i + w] -= need;
            }
        }
        
        return true;
    }
}