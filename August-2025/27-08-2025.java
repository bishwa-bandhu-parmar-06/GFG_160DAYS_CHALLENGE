// Count the number of possible triangles
// Difficulty: MediumAccuracy: 28.53%Submissions: 146K+Points: 4Average Time: 15m
// Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.



class Solution {
    public int countTriangles(int arr[]) {
        // code here
          Arrays.sort(arr);
        int n=arr.length;
        int count=0;
        for(int i=n-1;i>=0;i--)
        {
            int min=arr[i];
            int j=0;
            int k=i-1;
            while(j<k)
            {
                if(arr[j]+arr[k]>min)
                {
                    count+=k-j;
                    k--;
                }
                else j++;
            }
        }
        return count;
    }
}