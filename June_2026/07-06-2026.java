// Finding Profession
// Difficulty: MediumAccuracy: 30.3%Submissions: 29K+Points: 4Average Time: 20m
// Consider a special family of Engineers and Doctors with following rules :

// Everybody has two children.
// First child of an Engineer is an Engineer and second child is a Doctor.
// First child of an Doctor is Doctor and second child is an Engineer.
// All generations of Doctors and Engineers start with Engineer.
// The first few levels of the family tree are shown below :


// Given level and position (pos) of a person in above ancestor tree, find profession of the person.

class Solution {
static int countBit(int num) {
int count = 0;
while (num>0) {
num &= (num - 1);
count++;
}
return count;
}
public String profession(int level, int pos) {
// code here
 
boolean val = (countBit(pos - 1)&1) == 0;
 
return val?"Engineer":"Doctor";
 
}
}