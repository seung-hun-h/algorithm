from sys import stdin
from collections import deque
readline = stdin.readline

length = 101
_map = [[0 for _ in range(length)] for _ in range(length)]
visited = [[False for _ in range(length)] for _ in range(length)]
ans = 0
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)

def solve():
    for _ in range(4):
        x1, y1, x2, y2 = map(int, readline().split())
        paint(x1, y1, x2, y2)

    for r in range(1, length):
        for c in range(1, length):
            if _map[r][c] == 1 and not visited[r][c]:
                bfs(r, c)

def paint(x1, y1, x2, y2):
    for r in range(y1, y2):
        for c in range(x1, x2):
            _map[r][c] = 1

def bfs(row, col):
    global ans
    q = deque()
    visited[row][col] = True
    q.append([row, col])
    
    while q:
        r, c = q.popleft()
        ans += 1

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]

            if 0<nr<length and 0<nc<length and _map[nr][nc] and not visited[nr][nc]:
                q.append([nr, nc])
                visited[nr][nc] = True
solve()
print(ans)