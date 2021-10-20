from sys import stdin
from collections import deque
readline = stdin.readline

R, C = map(int, readline().split())
maze = [list(readline().strip()) for _ in range(R)]
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)

def solve():
    q = deque()

    fires = []
    person = []

    for r in range(R):
        for c in range(C):
            if maze[r][c] == "F":
                fires.append([r, c])
            elif maze[r][c] == "J":
                person = [r, c]
                maze[r][c] = "."
    
    for f in fires:
        q.append([f[0], f[1], 1, 1])
    q.append([person[0], person[1], 0, 1])

    
    while q:
        r, c, f, d = q.popleft()

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]

            if 0<=nr<R and 0<=nc<C:
                if maze[nr][nc] == ".":
                    if f:
                        maze[nr][nc] = "F"
                    else:
                        maze[nr][nc] = "_"
                    q.append([nr, nc, f, d+1])

            else:
                if not f:
                    print(d)
                    return
    print("IMPOSSIBLE")
solve()