from sys import stdin
from collections import deque
readline = stdin.readline

dr = [0, 0, 1, -1]
dc = [1, -1, 0 , 0]
N, L, R = map(int, readline().split())
_map = [list(map(int, readline().split())) for _ in range(N)]

def solve():
    flag = True
    cnt = 0
    while flag:
        visited = [[False] * N for _ in range(N)]
        flag = False
        for r in range(N):
            for c in range(N):
                if not visited[r][c]:
                    visited[r][c] = True
                    unite, mean = find_unites(r, c, visited)
                    if len(unite) > 1: 
                        flag = True
                        for u in unite:
                            _map[u[0]][u[1]] = mean
            
        if not flag: break                    
        
        cnt += 1
    
    print(cnt)

def find_unites(r, c, visited):
    q = deque()
    q.append([r, c])
    unite = []
    total = 0
    while q:
        r, c = q.popleft()
        total += _map[r][c]
        unite.append([r, c])

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            
            if 0 <= nr < N and 0 <= nc < N and not visited[nr][nc]:
                if L <= abs(_map[r][c] - _map[nr][nc]) <= R:
                    visited[nr][nc] = True
                    q.append([nr, nc])
    
    return unite, total // len(unite)

solve()