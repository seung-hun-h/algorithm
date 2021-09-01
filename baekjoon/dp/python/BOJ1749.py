"""
link = https://www.acmicpc.net/problem/1749
SOLVING : 7m 
IMPLEMENTATION: 15m
DEBUGING: 33m
CLEAR : X
최소 값을 너무 크게 잡았다. 
"""

from sys import stdin
readline = stdin.readline

N, M = map(int, readline().split())
_map = [[0] * (M+1)] +[[0] + list(map(int, readline().split())) for _ in range(N)]
dp = [[0 for _ in range(M+1)] for _ in range(N+1)]

def solve():
    dp[1][1] = _map[1][1]
    for i in range(2, M+1):
        dp[1][i] = dp[1][i-1] + _map[1][i]
    for i in range(2, N+1):
        dp[i][1] = dp[i-1][1] + _map[i][1]

    for r in range(2, N+1):
        for c in range(2, M+1):
            dp[r][c] = dp[r-1][c] + dp[r][c-1] - dp[r-1][c-1] + _map[r][c]
    ans = -int(1e9)
    for r in range(1, N+1):
        for c in range(1, M+1):
            for x in range(r, N+1):
                for y in range(c, M+1):
                    # if r==x and c==y: continue
                    cur = dp[x][y] - dp[r-1][y] - dp[x][c-1] + dp[r-1][c-1]
                    ans = max(cur, ans)

    print(ans)

solve()