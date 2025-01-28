// Permutations of a String
// Difficulty: Medium    Accuracy: 34.65%            Submissions: 294K+   Accuracy  Points: 4
// Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.


class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // Sorting to handle duplicates
        boolean[] used = new boolean[s.length()];
        backtrack(result, new StringBuilder(), arr, used);
        return result;
    }

    private void backtrack(ArrayList<String> result, StringBuilder temp, char[] arr, boolean[] used) {
        if (temp.length() == arr.length) {
            result.add(temp.toString());
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i - 1])) {
                continue; // Skip duplicates
            }

            used[i] = true;
            temp.append(arr[i]);
            backtrack(result, temp, arr, used);
            used[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}