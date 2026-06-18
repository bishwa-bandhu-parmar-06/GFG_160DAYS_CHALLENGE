# // Coverage of all Zeros in a Binary Matrix
# // Difficulty: EasyAccuracy: 55.68%Submissions: 29K+Points: 2Average Time: 10m
# // Given a binary matrix mat[][] containing only 0s and 1s, find the total coverage of all 0's. The coverage of a particular 0 cell is defined by checking 1's in its four directions (left, right, up, and down). For each direction, if there is at least one 1 anywhere between the 0 and the boundary of the matrix, the coverage increases by one.

# // Return the sum of the coverage values for all 0 cells in the matrix.


def findCoverage(self, mat):
        m, n = len(mat), len(mat[0])

        def count_coverage(itr):
            coverage = 0
            has_one = False
            for cell in itr:
                if cell:
                    has_one = True
                elif has_one:
                    coverage += 1
            return coverage

        coverage = 0
        for row in mat:
            coverage += count_coverage(row)
            coverage += count_coverage(reversed(row))
        for col_i in range(n):
            coverage += count_coverage(mat[row_i][col_i] for row_i in range(m))
            coverage += count_coverage(mat[row_i][col_i] for row_i in reversed(range(m)))
        return coverage