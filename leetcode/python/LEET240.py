from typing import *

def searchMatrix(matrix: List[List[int]], target: int) -> bool:
    return any([target in row for row in matrix])

def searchMatrix2(matrix: List[List[int]], target: int) -> bool:
    if not matrix:
        return False

    row = 0
    col = len(matrix[0]) - 1

    while row < len(matrix) and col >= 0:
        if target == matrix[row][col]:
            return True

        elif target < matrix[row][col]:
            col -= 1

        else:
            row += 1

    return False  