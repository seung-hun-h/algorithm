from sys import stdin
from collections import deque
readline = stdin.readline

M, N = map(int, readline().split())
_map = [list(map(int, readline().split())) for _ in range(M)]
start = list(map(int, readline().split()))
end = list(map(int, readline().split()))
visited = [[[False for _ in range(5)] for _ in range(N)] for _ in range(M)]
# 0: 빈칸 , 1: 벽
def solve():
    q = deque()
    q.append([start[0]-1, start[1]-1, start[2], 0])
    visited[start[0]-1][start[1]-1][start[2]] = True
    
    while q:
        r, c, d, cnt = q.popleft()
        if r == end[0]-1 and c == end[1]-1:
            if d == end[2]:
                return cnt
            if (end[2] >= 3 and d >=3) or (end[2] < 3 and d < 3):
                return cnt + 2
            return cnt + 1

        # Go k
        for i in range(1, 4):
            # East
            if d == 1:
                nr, nc = r, c + i
                if nc < N and not visited[nr][nc][d]:
                    if _map[nr][nc] == 1: break
                    visited[nr][nc][d] = True
                    q.append([nr, nc, d ,cnt+1])
            # West
            elif d == 2:
                nr, nc = r, c - i
                if 0 <= nc and not visited[nr][nc][d]:
                    if _map[nr][nc] == 1:
                        break
                    visited[nr][nc][d] = True
                    q.append([nr, nc, d ,cnt+1])
            # South
            elif d == 3:
                nr, nc = r + i, c
                if nr < M and not visited[nr][nc][d]: 
                    if _map[nr][nc] == 1:
                        break
                    visited[nr][nc][d] = True
                    q.append([nr, nc, d ,cnt+1])
            # North
            else:
                nr, nc = r - i, c
                if 0 <= nr and not visited[nr][nc][d]:
                    if _map[nr][nc] == 1:
                        break
                    visited[nr][nc][d] = True
                    q.append([nr, nc, d ,cnt+1])

        # Turn dir
        if d == 3 or d == 4:
            if not visited[r][c][2]:
                q.append([r, c, 2, cnt+1])
                visited[r][c][2] = True
            if not visited[r][c][1]:
                q.append([r, c, 1, cnt+1])
                visited[r][c][1] = True
            
        else:
            if not visited[r][c][3]:
                q.append([r, c, 3, cnt+1])
                visited[r][c][3] = True
            if not visited[r][c][4]:
                q.append([r, c, 4, cnt+1])
                visited[r][c][4] = True
print(solve())