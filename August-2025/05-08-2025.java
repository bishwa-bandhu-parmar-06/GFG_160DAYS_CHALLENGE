// Palindrome Sentence
// Difficulty: EasyAccuracy: 50.04%Submissions: 33K+Points: 2
// Given a single string s, the task is to check if it is a palindrome sentence or not.
// A palindrome sentence is a sequence of characters, such as word, phrase, or series of symbols that reads the same backward as forward after converting all uppercase letters to lowercase and removing all non-alphanumeric characters (including spaces and punctuation).


public class Solution {
    public boolean isPalinSent(String s) {
        
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();  
        Solution sol = new Solution();
        boolean result = sol.isPalinSent(s);
        System.out.println(result);
    }
}

