// Counting elements in two arrays
// Difficulty: MediumAccuracy: 37.12%Submissions: 81K+Points: 4Average Time: 20m
// You are given two unsorted arrays a[] and b[]. Both arrays may contain duplicate elements. For each element in a[], your task is to count how many elements in b[] are less than or equal to that element.

class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        ArrayList<Integer>res=new ArrayList<>();
        HashMap<Integer,Integer>hm=new HashMap<>();
        int i=0,j=0;
        int r[]=new int[a.length];
        for(int k=0;k<a.length;k++)
        {
            r[k]=a[k];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int c=0;
        while(i<a.length && j<b.length)
        {
                while(j<b.length && a[i]>=b[j])
                {
                    c++;
                    j++;
                }
                hm.put(a[i],c);
                i++;
        }
        for(int x=0;x<a.length;x++)
        {
            if(hm.containsKey(r[x]))
            res.add(hm.get(r[x]));
            else
            {
                res.add(c);
            }
        }
        return res;
    }
}






