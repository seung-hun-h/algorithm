from sys import stdin
from collections import defaultdict

readline = stdin.readline

INF = float('inf')
N, M = map(int, readline().split())
dist = [[INF for _ in range(N + 1)] for _ in range(N + 1)]

def solve():

    for i in range(N + 1):
        dist[i][i] = 0

    for _ in range(M):
        u, v = map(int, readline().split())
        dist[u][v] = 1
        dist[v][u] = 1

    for k in range(1, N + 1):
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                if i == j: continue

                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]


    ans = [-1, -1, INF]
    for i in range(1, N):
        for j in range(i + 1, N + 1):

            if ans[0] == -1:
                ans = [i, j, get_dist(i, j, dist)]
                continue
            
            current = get_dist(i, j, dist)

            if ans[-1] > current:
                ans = [i, j, current]

    print(*ans)

def get_dist(u, v, dist):

    result = 0

    for i in range(1, N + 1):
        result += min(dist[u][i], dist[v][i])

    return result * 2

solve()
