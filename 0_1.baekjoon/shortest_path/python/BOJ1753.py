from sys import stdin
from collections import defaultdict
import heapq

readline = stdin.readline

V, E = map(int, readline().split())
K = int(readline())
graph = defaultdict(list)
dist = defaultdict(lambda: float('inf'))

def solve():
    for _ in range(E):
        n, m, v = map(int, readline().split())
        graph[n].append([m, v])
    
    dijkstra()

    for i in range(1, V + 1):
        print(dist[i] if dist[i] != float('inf') else 'INF')

def dijkstra():
    pq = [[0, K]]
    dist[K] = 0
    while pq:
        weight, node = heapq.heappop(pq)

        if weight > dist[node]: continue

        for v, w in graph[node]:
            alt = weight + w

            if dist[v] > alt:
                dist[v] = alt
                heapq.heappush(pq, [alt, v])

solve()