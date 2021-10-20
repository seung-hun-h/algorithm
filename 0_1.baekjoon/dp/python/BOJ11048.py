"""
link = https://www.acmicpc.net/problem/11048
SOLVING : 1m 27s 
IMPLEMENTATION: 5m 26s
DEBUGING: 8m 25s
CLEAR : O
"""
from sys import stdin
readline = stdin.readline

N, M = map(int, readline().split())

_map = [[0] * (M+1)] + [[0] + list(map(int, readline().split())) for _ in range(N)]
dp = [[0] * (M+1) for _ in range(N+1)]


def solve():
    for r in range(1, N+1):
        for c in range(1, M+1):
            dp[r][c] = max(dp[r-1][c-1], dp[r-1][c], dp[r][c-1]) + _map[r][c]
    print(dp[N][M])
solve()

