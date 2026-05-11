// Palindrome Pairs
// Difficulty: HardAccuracy: 31.71%Submissions: 21K+Points: 8
// Given an array arr[] consisting of n strings. Determine whether there exists a pair of indices (i, j) such that i ≠ j and the concatenation arr[i] + arr[j] forms a palindrome.

// Return true if such a pair exists; otherwise, return false.

// Note: A string is considered a palindrome if it reads the same forward and backward.

// Examples:

// Input: arr[] = ["geekf", "geeks", "or", "keeg", "abc", "bc"]
// Output: true
// Explanation: There is a pair "geekf" and "keeg". Their concatenation "geekfkeeg" is a palindrome.
// Input: arr[] = ["abc", "xyxcba", "geekst", "or", "bc"]
// Output: true
// Explanation: There is a pair "abc" and "xyxcba". Their concatenation "abcxyxcba" is a palindrome.
// Input: arr[] = ["aa"]
// Output: false
// Explanation: There is only one string present, so the output is false.
// Constraints:
// 1 ≤ n ≤ 2*104
// 1 ≤ |arr[i]| ≤ 10


import java.util.*;

class Solution {

    static boolean palindromePair(String[] arr) {

        int n = arr.length;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        for(int i = 0; i < n; i++) {

            String word = arr[i];
            int len = word.length();

            for(int j = 0; j <= len; j++) {

                String left = word.substring(0, j);
                String right = word.substring(j);

                // Case 1
                if(isPalindrome(left)) {

                    String rev = new StringBuilder(right).reverse().toString();

                    if(map.containsKey(rev) && map.get(rev) != i)
                        return true;
                }

                // Case 2
                if(j != len && isPalindrome(right)) {

                    String rev = new StringBuilder(left).reverse().toString();

                    if(map.containsKey(rev) && map.get(rev) != i)
                        return true;
                }
            }
        }

        return false;
    }

    static boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while(i < j) {

            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}


