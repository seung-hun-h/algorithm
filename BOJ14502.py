from sys import stdin, setrecursionlimit
from collections import deque
import copy
readline = stdin.readline
setrecursionlimit(10 ** 6)

def bfs():
    global result
    temp = [[_map[i][j] for j in range(M)] for i in range(N)]
    q = deque()
    
    for row in range(N):
        for col in range(M):
            if temp[row][col] == 2:
                q.append([row, col])

    while q:
        r, c = q.popleft()

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if 0 <= nr < N and 0 <= nc < M and temp[nr][nc] == 0:
                temp[nr][nc] = 2
                q.append([nr, nc])
    res = 0
    for row in range(N):
        for col in range(M):
            if temp[row][col] == 0:
                res += 1
    
    result = max(res, result)


def build_wall(wall, start_c):

    if wall == 3:
        bfs()
        return

    for row in range(N):
        for col in range(start_c, M):
            if _map[row][col] == 0:
                _map[row][col] = 1
                build_wall(wall + 1, col)
                _map[row][col] = 0

if __name__ == '__main__':
    N, M = map(int, readline().split())
    _map = [list(map(int, readline().split())) for _ in range(N)]
    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]
    result = 0
    build_wall(0, 0)
    print(result)