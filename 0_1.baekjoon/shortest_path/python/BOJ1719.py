from sys import stdin
from collections import defaultdict

readline = stdin.readline

n, m = map(int, readline().split())
dp = [[float('inf') for _ in range(n + 1)] for _ in range(n + 1)]
trace = [[0 for _ in range(n + 1)] for _ in range(n + 1)]


def solve():

    for _ in range(m):
        u, v, c = map(int, readline().split())

        dp[u][v] = c
        dp[v][u] = c

        trace[u][v] = v
        trace[v][u] = u

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if i == j: continue

                if dp[i][j] > dp[i][k] + dp[k][j]:
                    dp[i][j] = dp[i][k] + dp[k][j]

                    trace[i][j] = k

    
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if trace[i][j] == 0:
                print("-", end=" ")

            else:
                x = trace[i][j]
                while trace[x][i] != i:
                    x = trace[x][i]

                print(x, end=" ")
        print()
solve()