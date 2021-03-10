from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 6)
readline = stdin.readline

N = int(readline())
dp = [[0] * N for _ in range(N)]
_map = [[0] * N for _ in range(N)]
for i in range(N):
    line = [*map(int, readline().split())]
    for j in range(len(line)):
        _map[i][j] = line[j]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(y, x):
    for d in dp:
        print(d)
    print()
    if dp[y][x]:
        return dp[y][x]

    dp[y][x] = 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0<=nx<N and 0<=ny<N:
            if _map[ny][nx] > _map[y][x]: 
                dp[y][x] = max(dp[y][x], dfs(ny, nx) + 1)

    return dp[y][x]


result = 0
for i in range(N):
    for j in range(N):
        result = max(result, dfs(i, j))

print(result)