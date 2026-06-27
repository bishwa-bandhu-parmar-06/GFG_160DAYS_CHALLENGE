# Ways to Tile the Floor
# Difficulty: MediumAccuracy: 39.12%Submissions: 14K+Points: 4
# Given a floor of dimensions n × m and an unlimited supply of tiles of size 1 × m, find the total number of ways to completely tile the floor.
# Each tile can be placed in one of the following ways:

# Horizontally, covering 1 row and m columns.
# Vertically, covering m rows and 1 column.
# Count all possible ways to cover the entire floor such that there are no overlaps and no uncovered cells.

# Since the number of possible tilings can be very large, return the answer modulo 109+7.

# Note: n and m are positive integers, and m ≥ 2.



from collections import defaultdict

class Solution:
	def countWays(self, n, m):

	    d = defaultdict(lambda: 0)
	    d[0] = 1

	    for i in range(1, n+1):
	        d[i] = (d[i-1] + d[i-m]) % (10**9+7) 

	    return d[n]