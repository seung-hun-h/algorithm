from sys import stdin
from collections import defaultdict
import heapq

readline = stdin.readline

N, M, X = map(int, readline().split())

graph = defaultdict(dict)

for _ in range(M):
    u, v, w = map(int, readline().split())
    graph[u][v] = w

def solve():
    # start - > end
    print(max([dijkstra(start, X) + dijkstra(X, start) for start in range(1, N+1)]))
def dijkstra(start, end):
    q = [(0, start)]
    weights = defaultdict(int)
    while q:
        dist, node = heapq.heappop(q)

        if node == end:
            return dist

        if node not in weights:
            weights[node] = dist
            for v in graph[node]:
                w = graph[node][v]
                alt = dist + w
                
                if v not in weights:
                    heapq.heappush(q, (alt, v))
    return weights[end]

solve()