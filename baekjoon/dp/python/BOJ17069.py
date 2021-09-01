from sys import stdin
readline = stdin.readline

N = int(readline())
_map = [[0] * (N+1)] + [[0]+list(map(int, readline().split())) for _ in range(N)]
dp = [[[0 for _ in range(N+1)] for _ in range(N+1)] for _ in range(3)]

def solve():
    dp[0][1][2] = 1
    for r in range(1, N+1):
        for c in range(1, N+1):
            if r == 1 and c == 1: continue
            if c < N and _map[r][c+1] != 1:
                dp[0][r][c+1] = dp[0][r][c] + dp[1][r][c]

            if r < N and _map[r+1][c] != 1:
                dp[2][r+1][c] = dp[1][r][c] + dp[2][r][c]

            if r < N and c < N and _map[r][c+1] != 1 and _map[r+1][c] != 1 and _map[r+1][c+1] != 1:
                dp[1][r+1][c+1] = dp[0][r][c] + dp[1][r][c] + dp[2][r][c]

    print(dp[0][N][N]+dp[1][N][N]+dp[2][N][N])
solve()