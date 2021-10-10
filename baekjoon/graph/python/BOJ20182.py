from sys import stdin
from collections import defaultdict
import heapq

readline = stdin.readline

N, M, A, B, C = map(int, readline().split())
graph = defaultdict(list)

for _ in range(M):
    n, m, c = map(int, readline().split())
    graph[n].append((m, c))
    graph[m].append((n, c))

def solve():
    left, right = 0, 10e14 + 1
    print(left, right)
    print(-1)

def dijkstra(limit):
    dist = defaultdict(lambda : float('inf'))
    pq = [(0, A)]

    dist[A] = 0

    while pq:
        cost, node = heapq.heappop(pq)

        if dist[node] != cost: continue

        for adj, w  in graph[node]:
            
            if w > limit: continue

            alt = cost + w

            if dist[adj] > alt:
                dist[adj] = alt
                heapq.heappush(pq, (alt, adj))
    return dist[B] <= C

solve()