from sys import stdin
from collections import deque
readline = stdin.readline

W, H = map(int, readline().split())
_map = [[0]*(W+2)]+\
        [[0]+list(map(int, readline().split()))+[0] for _ in range(H)] +\
        [[0]*(W+2)]

dr, dc = (1, -1, 0, 0, 1, -1), ((0, 0, 1, -1, -1, -1), (0, 0, 1, -1, 1, 1)) 

def solve():
    ans = 0
    q = deque()
    visited = [[False for _ in range(W+2)] for _ in range(H+2)]
    visited[0][0] = True
    q.append([0, 0])

    while q:
        r, c = q.popleft()

        for i in range(6):
            nr, nc = r + dr[i], c + dc[r%2][i]
            if nr < 0 or nr >= H+2 or nc < 0 or nc >= W+2:
                continue
            
            if _map[nr][nc] == 1:
                ans += 1
            elif not visited[nr][nc]:
                visited[nr][nc] = True
                q.append([nr, nc])

    print(ans)

solve()