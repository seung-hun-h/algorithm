from sys import stdin
from collections import deque
readline = stdin.readline

K = int(readline())
W, H = map(int, readline().split())
_map = [list(map(int, readline().split())) for _ in range(H)]
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)
hr, hc = (-1, -2, -2, -1, 1, 2, 2, 1), (-2, -1, 1, 2, -2, -1, 1, 2)
visited = [[[0 for _ in range(K+1)] for _ in range(W)] for _ in range(H)]
def solve():
    q = deque()
    q.append((0, 0, K))

    while q:
        r, c, k = q.popleft()
        
        if r == H-1 and c == W-1:
            return visited[r][c][k]

        # 인접 지역 이동
        for i in range(4):
            nr, nc = r+dr[i], c+dc[i]
            if 0<=nr<H and 0<=nc<W and _map[nr][nc] != 1 and visited[nr][nc][k] == 0:
                visited[nr][nc][k] = visited[r][c][k] + 1
                q.append((nr, nc, k))
        
        # 말 이동
        if k > 0:
            for i in range(8):
                nr, nc = r+hr[i], c+hc[i]
                if 0<=nr<H and 0<=nc<W and _map[nr][nc] != 1 and visited[nr][nc][k-1] == 0:
                    visited[nr][nc][k-1] = visited[r][c][k] + 1
                    q.append((nr, nc, k-1))

    return -1 

print(solve())