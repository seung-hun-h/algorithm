from sys import stdin
from collections import deque
readline = stdin.readline

N, M = map(int, readline().split())
_map = [list(map(int, readline().split())) for _ in range(N)]
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)
surface = [[0, 0]]

def solve():
    time = -1
    cnt = 0
    stack = [[0, 0]]

    while stack:
        cnt = len(stack) if stack else cnt
        time += 1
        while stack:
            r, c = stack.pop()
            _map[r][c] = 0
        
        q  = deque()
        visited = [[False for _ in range(M)] for _ in range(N)]
        q.append([0, 0])
        visited[0][0] = True
        traced = set()
        while q:
            r, c = q.popleft()

            for i in range(4):
                nr, nc = r + dr[i], c + dc[i]

                if not(0<=nr<N and 0<=nc<M):
                    continue
            
                if _map[nr][nc] == 1:
                    traced.add((nr, nc))
                elif not visited[nr][nc]:
                    visited[nr][nc] = True
                    q.append([nr, nc])

        stack = list(traced)

    print(time)
    print(cnt)

solve()