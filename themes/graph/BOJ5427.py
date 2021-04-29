from sys import stdin
from collections import deque
readline = stdin.readline

T = int(readline())
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)

def solve():

    for _ in range(T):
        w, h = map(int, readline().split())
        building = [list(readline().strip()) for _ in range(h)]

        # Find fires and person location
        fires = []
        person = []
        for r in range(h):
            for c in range(w):
                if building[r][c] == "*":
                    fires.append([r, c])
                elif building[r][c] == "@":
                    person = [r, c]
                    building[r][c] = "."
        # BFS
        result = bfs(building, fires, person, w, h)

        print(result if result != -1 else "IMPOSSIBLE")

def bfs(building, fires, person, w, h):
    # Deque: loctaion, flag 
    q = deque()

    for u, v in fires:
        q.append([u, v, 1, 1])
    q.append([person[0], person[1], 0, 1])

    while q:
        r, c, f, d = q.popleft()

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]

            if 0<=nr<h and 0<=nc<w:
                if building[nr][nc] == ".":
                    if f :
                        # Spread 
                        building[nr][nc] = "*"
                    else:
                        # Passed 
                        building[nr][nc] = "_"
                    q.append([nr, nc, f, d+1])
            else:
                # Exit
                if not f:
                    return d
    return -1
solve()
"""
1. deque 사용
처음 풀 때는 heapq 사용. 정렬 시간이 소요되기 때문에 풀리긴 헀으나 오래걸림

2. 불이 번질때 이미 상근이가 지나간 곳도 포함
기존 불이 번지는 코드에서는 상근이가 이미 지나간 곳도 포함 되어 있었다.
if building[nr][nc] == "*":
    ...
와 같이 코드를 작성했었는데, 이 코드는 이미 상근이가 지나가서 고려할 필요가 없는 곳에도
불이 번지기 때문에 시간이 훨씬 오래 걸린다.

- dist 배열에 불도 포함 시키거나
- building을 수정하여 상근이가 이미 지나간 곳을 표기하면 해결된다.


"""