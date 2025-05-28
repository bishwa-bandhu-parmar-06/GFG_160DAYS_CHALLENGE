// Find rectangle with corners as 1
// Difficulty: MediumAccuracy: 56.75%Submissions: 16K+Points: 4
// Given an n x m binary matrix mat[][] containing only 0s and 1s, determine if there exists a rectangle within the matrix such that all four corners of the rectangle are 1. If such a rectangle exists, return true; otherwise, return false.


class Solution {
    public boolean ValidCorner(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            List<Integer> rowOnes = new ArrayList<>();
            for (int j = 0; j < mat[0].length; j++) {
                
                if (mat[i][j] == 1) {
                    boolean onesFound = false;
                    
                    for (int k = i + 1; k < mat.length; k++) {
                        if (mat[k][j] == 1) {
                            onesFound = true;
                            for (int col: rowOnes) {
                                if (mat[k][col] == 1) return true;
                            }
                        }
                    }
                    
                    if (onesFound) rowOnes.add(j);
                }
            }
        }
        
        return false;
    }
}