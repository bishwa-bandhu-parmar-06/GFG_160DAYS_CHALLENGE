// Tywin's War Strategy
// Difficulty: EasyAccuracy: 38.28%Submissions: 8K+Points: 2
// You are given an array arr[] of size n, where arr[i] represents the number of soldiers in the i-th troop. You are also given an integer k. A troop is considered "lucky" if its number of soldiers is a multiple of k. Find the minimum total number of soldiers to add across all troops so that at least ⌈n / 2⌉ troops become lucky.




class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int l=arr.length;
        int r=0;
        int[] rs= new int[l];
        int c=0;
        for (int i=0;i<l;i++){
            if(arr[i]%k==0){
                c+=1;
                rs[i]=0;
            }else{
                rs[i]=k-arr[i]%k;
            }
        }
        int mid=0;
        if(l%2==0){
            mid=l/2;
        }else{
            mid=l/2+1;
        }
        // System.out.println(mid);
        //   System.out.println(c);
        if(mid==c){
            r=0;
        }else{
            Arrays.sort(rs);
            int d=mid-c;
            int i=0;
            while(i<d){
                // System.out.println(rs[c+i]);
                r+=rs[c+i];
                i++;
            }
        }
        return r;
    }
}