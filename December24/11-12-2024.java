// Merge Without Extra Space
// Difficulty: Hard       Accuracy: 32.01%      Submissions: 265K+       Points: 8
// Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.


class Solution {
    public void mergeArrays(int a[], int b[]) {
        int[] combinedArray=new int[a.length+b.length];
        System.arraycopy(a,0,combinedArray,0,a.length);
        System.arraycopy(b,0,combinedArray,a.length,b.length);
        Arrays.sort(combinedArray);
        for(int i=0;i<a.length;i++)
        {
            a[i]=combinedArray[i];
        }
        for(int j=0;j<b.length;j++)
        {
            b[j]=combinedArray[a.length+j];
        }
        
    }
}
