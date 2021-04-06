from sys import stdin  
from collections import deque
readline = stdin.readline

_map = [list(map(int, list(readline().strip()))) for _ in range(10)]
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)
def solve():
    p1, p2, p3 = get_points()

    points = [p1, p2, p3]
    for i in range(3):
        core = points[i]

        dist1 = abs(core[0] - points[(i+1) % 3][0]) ** 2 + abs(core[1] - points[(i+1) % 3][1]) ** 2
        dist2 = abs(core[0] - points[(i+2) % 3][0]) ** 2 + abs(core[1] - points[(i+2) % 3][1]) ** 2
        dist3 = abs(points[(i+2) % 3][0] - points[(i+1) % 3][0]) ** 2 + abs(points[(i+2) % 3][1] - points[(i+1) % 3][1]) ** 2

        if (dist1 + dist2) == dist3:
            points.sort(key=lambda x: [x[0], x[1]])
            for point in points:
                point[0] += 1
                point[1] += 1
                print(*point)
            return
        
    print(0)

def get_points():
    points = []
    flag = False
    for r in range(10):
        for c in range(10):
            if _map[r][c] == 1:
                points = bfs(r, c)
                flag = True
                break
        if flag:
            break
        
    if len(points) != 3:
        r1, c1 = points[0]
        r2, c2 = points[1]

        if _map[r1][c2]:
            points.append([r1, c2])
        elif _map[r2][c1]:
            points.append([r2, c1])
    return points

def bfs(row, col):
    points = []
    q = deque()
    visited = [[False for _ in range(10)] for _ in range(10)]
    q.append([row, col])
    visited[row][col] = True

    while q:
        cnt = 0
        r, c = q.popleft()

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]

            if 0<=nr<10 and 0<=nc<10:
                if not visited[nr][nc] and _map[nr][nc]:
                    visited[nr][nc] = True
                    q.append([nr, nc])
                elif not _map[nr][nc]:
                    cnt += 1
            else:
                cnt += 1
        if cnt == 3:
            points.append([r, c])

    return points

solve()