from sys import stdin
from collections import deque
readline = stdin.readline

N = int(readline())
_map = [list(map(int, readline().split())) for _ in range(N)]
parent = [i for i in range(N**2)]
starts = []
ans = N ** 2
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)

def solve():
    # 섬 찾기
    for r in range(N):
        for c in range(N):
            idx = r*N+c
            if _map[r][c] == 1 and parent[idx] == idx:
                build_set(r, c)

    # for i in range(N**2):
    #     print(parent[i], end=" ")
    #     if (i+1) % N == 0:
    #         print()
    # 다리 놓기
    # BFS > 다른 섬 & 처음으로 1인 경우 거리
    
    for s in starts:
        bfs(s[0], s[1])

def bfs(row, col):
    global ans

    q = deque()
    visited = [[False] * N for _ in range(N)]
    visited[row][col] = True
    p = row*N + col
    q.append([row, col, 0])

    while q:
        r, c, d = q.popleft()
        idx = r * N + c 

        if ans <= d:
            return

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            nidx = nr*N+nc

            if 0<=nr<N and 0<=nc<N and not visited[nr][nc]:
                if _map[nr][nc] == 0:
                    q.append([nr, nc, d+1])
                    visited[nr][nc] = True
                elif _map[nr][nc] == 1 and parent[p] != parent[nidx]:
                    ans = d
                    return


def build_set(row, col):
    q = deque()
    p = row*N+col
    visited = [[False] * N for _ in range(N)]

    visited[row][col] = True
    q.append([row, col])
   
    while q:
        r, c = q.popleft()
        idx = r*N+c
        
        flag = False
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            nn = nr*N+nc
            if 0<=nr<N and 0<=nc<N:
                if _map[nr][nc] == 1 and not visited[nr][nc]:
                    visited[nr][nc] = True
                    parent[nn] = p
                    q.append([nr, nc])
                if _map[nr][nc] == 0:
                    flag = True
        # 다리 시작 후보군 
        if flag:
            starts.append([r, c])

solve()
print(ans)