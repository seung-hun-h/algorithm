from sys import stdin
from collections import defaultdict
readline = stdin.readline

N = int(readline())
board = [list(map(int, readline().split())) for _ in range(N)]
INF = float('inf')

dp = [[INF for _ in range(1<<N)] for _ in range(N)]

def solve():
    print(tsp(0, 1))

def tsp(node, visited):
    if (visited == (1 << N) - 1):
        return board[node][0] or INF

    if dp[node][visited] != INF:
        return dp[node][visited]

    for i in range(N):
        if not board[node][i]: continue
        if visited & (1 << i): continue 

        dp[node][visited] = min(dp[node][visited], tsp(i, visited | 1 << i) + board[node][i])


    return dp[node][visited]

solve()