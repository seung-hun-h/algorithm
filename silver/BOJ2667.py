from sys import stdin
from collections import deque

readline = stdin.readline

def count_blob():
    ans = []
    for i in range(N):
        for j in range(N):
            if _map[i][j] != 0:
                ans.append(count_connected_house(i, j))    
    print(len(ans))
    ans.sort()
    for a in ans:
        print(a)

def count_connected_house(row, col):
    q = deque()
    q.append([row, col])
    cnt = 0
    while q:
        r, c = q.popleft()
        _map[r][c] = 0
        cnt += 1

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if 0 <= nr < N and 0 <= nc < N and _map[nr][nc] == 1:
                q.append([nr, nc])
                _map[nr][nc] = 0
    
    return cnt


if __name__ == "__main__":
    N = int(readline())
    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]


    _map = [list(map(int, list(readline().strip()))) for _ in range(N)]
    count_blob()