from sys import stdin
from collections import deque

readline = stdin.readline

INF = 10000 * 500 + 1


def SPFA():
    dist = [INF] * n
    cycle = [0] * n
    on = [False] * n
    q = deque()
    
    q.append(0)
    dist[0] = 0
    on[0] = True
    while q:
        u = q.popleft()
        on[u] = False

        for v, _w in graph[u]:
            if dist[v] > dist[u] + _w:
                dist[v] = dist[u] + _w
                if not on[v]:
                    q.append(v)
                    on[v] = True
                    cycle[v] += 1

                    if cycle[v] == n:
                        print(-1)
                        return
    all_negative = True
    for i in range(1, n):
        if dist[i] >= 0:
            all_negative = False
    if all_negative:
        print(-1)
        return
    for i in range(1, n):
        print(dist[i] if dist[i] != INF else -1)

if __name__ == "__main__":
    n, m = map(int, readline().split())
    graph = [[] for _ in range(n)]
    for _ in range(m):
        u, v, w = map(int, readline().split())
        graph[u-1].append([v-1, w])

    SPFA()