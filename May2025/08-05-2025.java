// Missing element of AP
// Difficulty: MediumAccuracy: 34.32%Submissions: 58K+Points: 4
// Given a sorted array arr[] that represents an Arithmetic Progression (AP) with exactly one missing element, find the missing number.

// Note: An element will always exist that, upon inserting into a sequence forms Arithmetic progression. If the given sequence already forms a valid complete AP, return the (n+1)-th element that would come next in the sequence.

public int findMissing(int[] arr) {
    int n = arr.length;
  int d = arr[1]-arr[0];
  if((2*arr[0]+(n-1)*d)!=(arr[0]+arr[n-1]))
  {
      d=(arr[n-1]-arr[0])/n;
  }
  // common difference

 

int low = 0, high = n - 1;

  while (low <= high) {
      int mid = (low + high) / 2;
      int expected = arr[0] + mid * d;

      if (arr[mid] == expected) {
          // No mismatch yet, go right
          low = mid + 1;
      } else {
          // Found mismatch, go left to find first occurrence
          high = mid - 1;
      }
  }

  // Either missing element at position `low`, or array is complete
  return arr[0] + low * d;

}