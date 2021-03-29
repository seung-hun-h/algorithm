from sys import stdin
from collections import deque
readline = stdin.readline

N, M = map(int, readline().split())
_map = [list(map(int, list(readline().strip()))) for _ in range(N)]
visited = [[[False for _ in range(2)] for _ in range(M)] for _ in range(N)]

dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)


def solve():
    q = deque()

    q.append([0, 0, 0, 1])
    visited[0][0][0] = True

    while q:
        r, c, w, d = q.popleft()

        if r == N-1 and c == M-1:
            return d

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]

            if 0<=nr<N and 0<=nc<M:
                if _map[nr][nc] == 1 and w != 1 and not visited[nr][nc][1]:
                    visited[nr][nc][1] = True
                    q.append([nr, nc, 1, d+1])
                elif _map[nr][nc] == 0 and not visited[nr][nc][w]:
                    visited[nr][nc][w] = True  
                    q.append([nr, nc, w, d+1])
    return -1
print(solve())