from sys import stdin
from collections import defaultdict
import heapq
readline = stdin.readline

n, m, r = map(int, readline().split())
items = [0] + list(map(int, readline().split()))
graph = defaultdict(list)
INF = float('inf')

def solve():
    for _ in range(r):
        x, y, c = map(int, readline().split())
        graph[x].append([y, c])
        graph[y].append([x, c])

    print(max(bfs(i) for i in range(1, n + 1)))

def bfs(start):
    dist = defaultdict(lambda: INF)
    q = [[0, start]]
    result = 0

    while q:
        cost, node = heapq.heappop(q)

        if node not in dist:
            dist[node] = cost

            if cost <= m:
                result += items[node]

                for v, w in graph[node]:
                    alt = cost + w

                    if v not in dist:
                        heapq.heappush(q, [alt, v])

    return result


solve()