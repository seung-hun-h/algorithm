from sys import stdin
from collections import defaultdict
import heapq
readline = stdin.readline

V, E = map(int, readline().split())
K = int(readline())

graph = defaultdict(list)
for _ in range(E):
    u, v, w = map(int, readline().split())
    graph[u].append((v, w))

def solve():
    dist = defaultdict(int)
    # 가중치, 정점
    q = [(0, K)]

    while q:
        weight, node = heapq.heappop(q)
        if node not in dist:
            dist[node] = weight
            for v, w in graph[node]:
                alt = weight + w
                if v not in dist:
                    heapq.heappush(q, (alt, v))
    for i in range(1, V+1):
        if i in dist:
            print(dist[i])
        else:
            print("INF")
solve()