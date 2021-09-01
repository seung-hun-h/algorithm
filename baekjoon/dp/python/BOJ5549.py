"""
link = https://www.acmicpc.net/problem/5549
SOLVING : 3m 20s 
IMPLEMENTATION: 12m
DEBUGING: 0m
CLEAR : O
"""
from sys import stdin
readline = stdin.readline

M, N = map(int, readline().split())
K = int(readline())

_map = [[[0, 0, 0] for _ in range(N+1)] for _ in range(M+1)]

for r in range(1, M+1):
    line = list(readline())
    for c in range(1, N+1):
        if line[c-1] == "J":
            _map[r][c][0] += 1
        elif line[c-1] == "O":
            _map[r][c][1] += 1
        else:
            _map[r][c][2] += 1

def solve():
    dp = [[[0, 0, 0] for _ in range(N+1)] for _ in range(M+1)]
    dp[1][1] = _map[1][1]

    for r in range(1, M+1):
        for c in range(1, N+1):
            for k in range(3):
                dp[r][c][k] = _map[r][c][k] + dp[r-1][c][k] + dp[r][c-1][k] - dp[r-1][c-1][k]

    for _ in range(K):
        r1, c1, r2, c2 = map(int, readline().split())
        for k in range(3):
            cur = dp[r2][c2][k] - dp[r2][c1-1][k] - dp[r1-1][c2][k] + dp[r1-1][c1-1][k]
            print(cur, end=" ")
        print()
solve()