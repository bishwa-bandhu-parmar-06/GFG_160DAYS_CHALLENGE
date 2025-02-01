// Search Pattern (KMP-Algorithm)
// Difficulty: Medium        Accuracy: 45.04%       Submissions: 77K+      Points: 4
// Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices. 
// Note: Return an empty list in case of no occurrences of pattern.

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> foundPatternList = new ArrayList<>();
        if(txt == null || txt.isEmpty() || pat.length() > txt.length())
            return foundPatternList;
        int index = txt.indexOf(pat);
        while(index != -1) {
            foundPatternList.add(index);
            index = txt.indexOf(pat, index+1);
        }
        return foundPatternList;
    }
}


