// Decode the string
// Difficulty: MediumAccuracy: 44.28%Submissions: 48K+Points: 4Average Time: 10m
// Given an encoded string s, the task is to decode it. The encoding rule is :

// k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
// Note: The test cases are generated so that the length of the output string will never exceed 105 .

class Solution {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder decodedString = new StringBuilder();
        int index = 0;
        
        while (index < s.length()) {
            char ch = s.charAt(index);
            
            if (Character.isDigit(ch)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (ch == '[') {
                stringStack.push(decodedString);
                decodedString = new StringBuilder();
                index++;
            } else if (ch == ']') {
                StringBuilder temp = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(decodedString);
                }
                decodedString = temp;
                index++;
            } else {
                decodedString.append(ch);
                index++;
            }
        }
        
        return decodedString.toString();
    }
}
