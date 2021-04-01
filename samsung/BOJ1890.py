from sys import stdin
readline = stdin.readline

N = int(readline())
_map = [list(map(int, readline().split())) for _ in range(N)]
dp = [[0 for _ in range(N)] for _ in range(N)]

def solve():
    dp[0][0] = 1

    for row in range(N):
        for col in range(N):
            if row == N-1 and col == N-1: break
            nr = row + _map[row][col]
            nc = col + _map[row][col]
            if nr < N:
                dp[nr][col] += dp[row][col]
            if nc < N:
                dp[row][nc] += dp[row][col]
solve()
print(dp[N-1][N-1])