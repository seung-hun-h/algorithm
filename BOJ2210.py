from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 6)
readline = stdin.readline

_map = [list(map(int, readline().split())) for _ in range(5)]
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)
include = [False] * 10000000
ans = 0

def dfs(row, col, cnt, cur):
    global ans
    if cnt == 6: 
        if not include[cur]:
            include[cur] = True
            ans += 1
        return

    for i in range(4):
        nr, nc = row + dr[i], col + dc[i]
        if 0<=nr<5 and 0<=nc<5:
            dfs(nr, nc, cnt+1, cur*10+_map[nr][nc])

for row in range(5):
    for col in range(5):
        dfs(row, col, 1, _map[row][col])

print(ans)