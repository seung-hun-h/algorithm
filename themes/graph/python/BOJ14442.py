from sys import stdin   
from collections import deque
readline = stdin.readline
N, M, K = map(int, readline().split())
_map = [list(map(int, list(readline().strip()))) for _ in range(N)]
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)

def solve():
    q = deque()
    q.append([0, 0, 0])
    dist = [[[0 for _ in range(K+1)] for _ in range(M)] for _ in range(N)]
    dist[0][0][0] = 1
    
    while q:
        r, c, w = q.popleft()

        if r == N-1 and c == M-1:
            print(dist[r][c][w])
            return

        for i in range(4):
            nr, nc, nw = r + dr[i], c + dc[i], w+1
            if 0<=nr<N and 0<=nc<M:
                if nr == N-1 and nc == M-1:
                    print(dist[r][c][w] + 1)
                    return
                if _map[nr][nc] == 0 and not dist[nr][nc][w]:
                    dist[nr][nc][w] = dist[r][c][w] + 1
                    q.append([nr, nc, w])
                
                if _map[nr][nc] == 1 and nw <= K and not dist[nr][nc][nw]:

                    dist[nr][nc][nw] = dist[r][c][w] + 1
                    q.append([nr, nc, nw])

    print(-1)
solve()