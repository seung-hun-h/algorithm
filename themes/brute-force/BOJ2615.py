from sys import stdin
readline = stdin.readline

N = 19
_map = [list(map(int, readline().split())) for _ in range(N)]
dr = (-1, -1, -1, 0, 1, 1, 1, 0)
dc = (-1, 0, 1, 1, 1, 0, -1, -1)

def solve():
    for r in range(N):
        for c in range(N):
            if _map[r][c]:
                row, col = check(r, c)
                if row != -1:
                    print(_map[r][c])
                    print(row+1, col+1)
                    return

    print(0)

def check(row, col):
    target = _map[row][col]
    for i in range(8):
        min_col = col
        min_row = row
        cnt = 1
        nr, nc = row + dr[i], col + dc[i]

        while 0<=nr<N and 0<=nc<N and _map[nr][nc] == target:
            if nc < min_col:
                min_row, min_col = nr, nc
            elif nc == min_col and nr < min_row:
                min_row, min_col = nr, nc
            cnt += 1
            nr, nc = nr + dr[i], nc + dc[i]


        nr, nc = row + dr[(i+12) % 8], col + dc[(i+12) % 8]
        while 0<=nr<N and 0<=nc<N and _map[nr][nc] == target:
            if nc < min_col:
                min_row, min_col = nr, nc
            elif nc == min_col and nr < min_row:
                min_row, min_col = nr, nc
            cnt += 1
            nr, nc = nr + dr[(i+12) % 8], nc + dc[(i+12) % 8]    

        if cnt == 5:
            return min_row, min_col

    return -1, -1

solve()