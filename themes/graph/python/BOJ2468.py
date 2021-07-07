from sys import stdin
import copy
import collections
readline = stdin.readline

N = int(readline())
area = [list(map(int, readline().split())) for _ in range(N)]
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)


def solve():
    max_area = 1

    for height in range(1, 101):
        _copy = copy.deepcopy(area)
        cnt = 0
        for r in range(N):
            for c in range(N):
                if _copy[r][c] > height:
                    # bfs(r, c, _copy, height)
                    iter_dfs(r, c, _copy, height)
                    cnt += 1
        if cnt == 0:
            break
        max_area = max(max_area, cnt)
    print(max_area)

def iter_dfs(row, col, _map, height):
    stack = [[row, col]]
    _map[row][col] = 0
    while stack:
        r, c = stack.pop()
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            if 0<=nr<N and 0<=nc<N and _map[nr][nc] > height:
                stack.append([nr, nc])
                _map[nr][nc] = 0
    
def dfs(row, col, _map, height):
    if row < 0 or col < 0 or \
        row >= N or col >= N or\
             _map[row][col] <= height:
        return

    _map[row][col] = 0

    dfs(row+1, col, _map, height)
    dfs(row-1, col, _map, height)
    dfs(row, col+1, _map, height)
    dfs(row, col-1, _map, height)


def bfs(row, col, _map, height):
    q = collections.deque()
    _map[row][col] = 0
    q.append([row, col])

    while q:
        r, c = q.popleft()

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]

            if 0<=nr<N and 0<=nc<N and _map[nr][nc] > height:
                _map[nr][nc] = 0
                q.append([nr, nc])

solve()   