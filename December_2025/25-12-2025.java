// Find the Peak Element in a 2D Matrix
// Difficulty: MediumAccuracy: 54.61%Submissions: 12K+Points: 4
// Given a 2D matrix mat[][], identify any peak element within the matrix.

// An element is considered a peak if it is greater than or equal to its four immediate neighbors: top, bottom, left, and right. For corner and edge elements, any missing neighbors are treated as having a value of negative infinity.

// Note: A peak element is not necessarily the global maximum, it only needs to satisfy the condition relative to its adjacent elements. Multiple peak elements may exist, return any one of them.
// Note that the driver code will print true if you return the correct position of peak element, else it will print false.


class Solution {

    public ArrayList<Integer> findPeakGrid(int[][] mat) {

        // code here

           ArrayList<Integer> li=new ArrayList<>();

        int i=0;

        int j=mat[0].length-1;

        while(i<mat.length&&j>=0)

        {

            int top=(i-1>=0)? mat[i-1][j]:Integer.MIN_VALUE;

            int bottom=(i+1<mat.length)? mat[i+1][j]:Integer.MIN_VALUE;

            int left= (j-1>=0)? mat[i][j-1]:Integer.MIN_VALUE;

            int right=(j+1<mat[0].length)? mat[i][j+1]:Integer.MIN_VALUE;

            

            if(mat[i][j]<top)

            {

                i=i-1;

            }

            else if(mat[i][j]<bottom)

            {

                i=i+1;

            }

            else if(mat[i][j]<left)

            {

                j=j-1;

            }

            else if(mat[i][j]<right)

            {

                j=j+1;

            }

            else

            {

                li.add(i);

                li.add(j);

                return li;

            }

        }

        return li;

    }

}