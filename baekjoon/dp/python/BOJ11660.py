from sys import stdin
readline = stdin.readline

N, M = map(int, readline().split())
_map = [[0] * (N+1)] + [[0]+list(map(int, readline().split())) for _ in range(N)]
dp = [[0 for _ in range(N+1)] for _ in range(N+1)]


def solve():
    dp[1][1] = _map[1][1]

    for i in range(2, N+1):
        dp[1][i] = dp[1][i-1] + _map[1][i]
        dp[i][1] = dp[i-1][1] + _map[i][1]
    
    for r in range(2, N+1):
        for c in range(2, N+1):
            dp[r][c] = _map[r][c] + dp[r][c-1] + dp[r-1][c] - dp[r-1][c-1]

    for _ in range(M):
        r1, c1, r2, c2 = map(int, readline().split())
        result = dp[r2][c2] - dp[r2][c1-1] - dp[r1-1][c2] + dp[r1-1][c1-1]
        print(result)

solve()