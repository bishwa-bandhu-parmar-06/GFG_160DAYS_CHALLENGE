# Last Digit of a^b
# Difficulty: MediumAccuracy: 23.8%Submissions: 95K+Points: 4
# Given two integers a and b in the form of strings. Return the last digit of ab.

# Examples:

# Input: a = "3", b = "10"
# Output: 9
# Explanation: 310 = 59049. Last digit is 9.
# Input: a = "6", b = "2"
# Output: 6
# Explanation: 62 = 36. Last digit is 6.
# Constraints:
# 1 ≤ a.size(), b.size() ≤ 1000
# a and b consist only of numeric digits ('0' - '9')
# a and b do not contain any leading zeros, except when number itself is "0"

class Solution:

    def getLastDigit(self, a, b):

        # code here

        a1=int(a[-1])

        if(len(b)==1):

            return pow(a1,(int(b)-1)%4+1)%10

        b1=int(b[-2:])-1

        c=b1%4

        return pow(a1,c+1)%10

