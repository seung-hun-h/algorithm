from typing import *
import collections

def numIslands(grid: List[List[str]]) -> int:
    visited = [[False] * len(grid[0]) for _ in range(len(grid))]
    cnt = 0
    for r in range(len(grid)):
        for c in range(len(grid[0])):
            if not visited[r][c] and grid[r][c] == "1":
                # bfs(r, c, grid, visited)
                iter_dfs(r, c, grid, visited)
                cnt += 1

    return cnt
def iter_dfs(row: int, col: int, grid: List[List[str]], visited: List[List[bool]]):
    stack = [[row, col]]
    visited[row][col] = True
    dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)
    while stack:
        r, c = stack.pop()
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            if 0<=nr<len(grid) and 0<=nc<len(grid[0]) and grid[nr][nc] == "1" and not visited[nr][nc]:
                stack.append([nr, nc])
                visited[nr][nc] = True

def dfs(row: int, col: int, grid: List[List[str]], visited: List[List[bool]]):
    visited[row][col] = True
    dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)

    for i in range(4):
        nr, nc = row + dr[i], col + dc[i]

        if 0<=nr<len(grid) and 0<=nc<len(grid[0]) and grid[nr][nc] == "1" and not visited[nr][nc]:
            dfs(nr, nc, grid, visited)

def bfs(row: int, col: int, grid: List[List[str]], visited: List[List[bool]]):
    q = collections.deque()
    q.append([row, col])
    visited[row][col] = True
    dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)

    while q:
        r, c = q.popleft()

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]

            if 0<=nr<len(grid) and 0<=nc<len(grid[0]) and grid[nr][nc] == "1" and not visited[nr][nc]:
                visited[nr][nc] = True
                q.append([nr, nc])

def numIslands2(grid: List[List[str]]) -> int:
    def dfs(row: int, col: int):
        if row < 0 or row >= len(grid) or \
            col < 0 or col >= len(grid[0]) or \
                grid[row][col] != '1':
                return
        grid[row][col] = '0'

        dfs(row+1, col)
        dfs(row-1, col)
        dfs(row, col+1)
        dfs(row, col-1)
    
    cnt = 0
    for r in range(len(grid)):
        for c in range(len(grid[0])):
            if grid[r][c] == "1":
                dfs(r, c)
                cnt += 1
    
    for g in grid:
        print(g)

    return cnt
    

def solve():
    grid = [
            ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
            ]
    res = numIslands2(grid)
    print(res)
solve()