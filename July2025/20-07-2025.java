// Count Numbers Containing Specific Digits
// Difficulty: MediumAccuracy: 70.29%Submissions: 6K+Points: 4Average Time: 25m
// You are given an integer n representing the number of digits in a number, and an array arr[] containing digits from 0 to 9. Your have to count how many n-digit positive integers can be formed such that at least one digit from the array arr[] appears in the number.





class Solution {
    public int countValid(int n, int[] arr) {
        if (n == 1) {
            Arrays.sort(arr);
            if(arr[0]==0){
            return arr.length-1;}
            else{
                return arr.length;
            }
        }
        long totalNumbers = 9; // Use long to prevent overflow for larger n
        for (int i = 0; i < n - 1; i++) {
            totalNumbers *= 10;
        }
        Set<Integer> arrSet = new HashSet<>();
        for (int digit : arr) {
            arrSet.add(digit);
        }

        int numUnavailableDigits = arr.length;
        int numAvailableNonArrDigits = 10 - numUnavailableDigits;

        long numbersWithoutArrDigits = 1;

        
        int firstDigitChoices = 0;
        for (int i = 1; i <= 9; i++) { // Iterate through 1-9
            if (!arrSet.contains(i)) {
                firstDigitChoices++;
            }
        }
        numbersWithoutArrDigits = firstDigitChoices;

      
        for (int i = 0; i < n - 1; i++) {
            numbersWithoutArrDigits *= numAvailableNonArrDigits;
        }

        return (int) (totalNumbers - numbersWithoutArrDigits);
    }
}