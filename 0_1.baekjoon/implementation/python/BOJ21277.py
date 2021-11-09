from sys import stdin
readline = stdin.readline

N1, M1 = map(int, readline().split())
mat1 = [list(map(int, list(readline().rstrip()))) for _ in range(N1)]
N2, M2 = map(int, readline().split())
mat2 = [list(map(int, list(readline().rstrip()))) for _ in range(N2)]

def solve():
    global mat2
    max_row = max(N1, N2)
    max_col = max(M1, M2)
    ans = float('inf')
    for _ in range(4):

        for row_offset in range(-max_row, max_row + 1):
            for col_offset in range(-max_col, max_col + 1):

                if not check(row_offset, col_offset): continue

                left = min(0, row_offset)
                right = max(N1, len(mat2) + row_offset)
                row_len = abs(left) + right

                left = min(0, col_offset)
                right = max(M1, len(mat2[0]) + col_offset)
                col_len = abs(left) + right

                ans = min(ans, row_len * col_len)

        mat2 = rotate(mat2)

    print(ans)

def check(row_offset, col_offset):

    for r in range(len(mat2)):
        for c in range(len(mat2[0])):
            nr, nc = r + row_offset, c + col_offset

            if nr < 0 or nr >= N1 or nc < 0 or nc >= M1: continue

            if mat1[nr][nc] == 1 and mat2[r][c] == 1:
                return False

    return True

def rotate(matrix):
    temp = [[0 for _ in range(len(matrix))] for _ in range(len(matrix[0]))]

    for r in range(len(matrix)):
        for c in range(len(matrix[0])):
            temp[c][len(matrix) - r - 1] = matrix[r][c]

    return temp
solve()