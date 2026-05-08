// Remove Invalid Parentheses
// Difficulty: HardAccuracy: 41.0%Submissions: 10K+Points: 8Average Time: 40m
// Given a string s consisting of lowercase letters and parentheses '(' and ')'.

// A string is considered valid if:

// Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
// Parentheses are properly nested.
// Remove the minimum number of invalid parentheses from s so that the resulting string becomes valid.  Return all the possible distinct valid strings in lexicographically sorted order.

// Examples :

// Input:  = "()())()"
// Output: ["(())()", "()()()"]
// Explanation: 
// The string "()())()" has one extra ')', making it invalid. By removing one ')', we can make it valid in two ways:
// Remove the 3rd index ')' -> "(())()"
// Remove the 4th index ')' -> "()()()"
// Both are valid and require the minimum removals.
// Input: s = "(a)())()"
// Output: ["(a())()", "(a)()()"]
// Explanation: 
// We remove one ')' (minimum removals) to make it valid. Possible valid results:
// Remove a ')' -> "(a())()"
// Remove another ')' -> "(a)()()"
// Input: s = ")("
// Output: [""]
// Explanation: The string ")(" is invalid. Removing both parentheses (minimum removals) gives an empty string "", which is valid.
// Constraints:
// 1 ≤ |s| ≤ 20
// s consists of lowercase English letters and parentheses '(' and ')'


class Solution {
  public:
    bool isValid(string s) {
        int count = 0;
        for(char ch : s) {
            if(ch == '(') {
                count++;
            }
            else if(ch == ')') {
                count--;
                if(count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
    vector<string> validParenthesis(string s) {
        vector<string> ans;
        unordered_set<string> visited;
        queue<string> q;
        q.push(s);
        visited.insert(s);
        bool found = false;
        while(!q.empty()) {
            int size = q.size();
            for(int z = 0; z < size; z++) {
                string curr = q.front();
                q.pop();
                if(isValid(curr)) {
                    ans.push_back(curr);
                    found = true;
                }
                // minimum level reached
                if(found) {
                    continue;
                }
                for(int i = 0; i < curr.size(); i++) {
                    if(curr[i] != '(' && curr[i] != ')') {
                        continue;
                    }
                    string next =
                        curr.substr(0, i) +
                        curr.substr(i + 1);
                    if(!visited.count(next)) {
                        visited.insert(next);
                        q.push(next);
                    }
                }
            }
            // stop after current level
            if(found) {
                break;
            }
        }
        return ans;
    }
};