// Check for Power
// Difficulty: BasicAccuracy: 34.59%Submissions: 60K+Points: 1
// Given two positive integers x and y, determine if y is a power of x. If y is a power of x, return true. Otherwise, return false.

// Examples:

// Input: x = 2, y = 8
// Output: true 
// Explanation: 23 is equal to 8.
// Input: x = 1, y = 8
// Output: false
// Explanation: Any power of 1 is not equal to 8.
// Input: x = 46, y = 205962976
// Output: true
// Explanation: 465 is equal to 205962976.
// Input: x = 50, y = 312500000
// Output: true
// Explanation: 505 is equal to 312500000.
// Constraints:
// 1 ≤ x ≤ 103
// 1 ≤ y ≤ 109

class Solution {
    public boolean isPower(int x, int y) {
        if (x == 1) {
            if (y == 1) {
                return true;
            } else {
                return false;
            }
        }

        while (y % x == 0) {
            y = y / x;
        }

        if (y == 1) {
            return true;
        } else {
            return false;
        }
    }
}




// Time Limit exceeded code :
// class Solution {
//     public boolean isPower(int x, int y) {
//         // code here
//         int result = 0;
//         int i = 0;
//         while(result != y){
//             result = (int) Math.pow(x, i);
//             i++;
//             if(result > y){
//                 break;
//             }
            
//         }
//         if(result == y){
//             return true;
//         }
        
//         return false;
//     }
    
// }
