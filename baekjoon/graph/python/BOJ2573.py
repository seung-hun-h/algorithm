from sys import stdin, setrecursionlimit
from collections import deque
setrecursionlimit(10 ** 6)
readline = stdin.readline

N, M = map(int, readline().split())
board = [list(map(int, readline().split())) for _ in range(N)]
dr, dc = [1, -1, 0, 0], [0, 0, 1, -1]

def solve():
    flag = True
    year = 1
    while flag:
        flag = False
        count = [[0 for _ in range(M)] for _ in range(N)]
        for r in range(N):
            for c in range(M):
                if board[r][c] == 0:
                    for i in range(4):
                        nr, nc = r + dr[i], c + dc[i]
                        if 0 <= nr < N and 0 <= nc < M and board[nr][nc] != 0:
                            count[nr][nc] += 1
                            flag = True

        for r in range(N):
            for c in range(M):
                if board[r][c] != 0:
                    board[r][c] -= count[r][c]
                    if board[r][c] < 0 :
                        board[r][c] = 0
        
        visited = [[False for _ in range(M)] for _ in range(M)]
        dvided = 0
        for r in range(N):
            for c in range(M):
                if board[r][c] != 0 and not visited[r][c]:
                    bfs(r, c, visited)
                    dvided += 1

        if dvided >= 2:
            return year

        year += 1

    return 0

def bfs(row, col, visited):
    q = deque()
    visited[row][col] = True
    q.append((row, col))

    while q:
        r, c = q.popleft()
  
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            if 0 <= nr < N and 0 <= nc < M and board[nr][nc] != 0:
                if not visited[nr][nc]:
                    visited[nr][nc] = True
                    q.append((nr, nc))

print(solve())

