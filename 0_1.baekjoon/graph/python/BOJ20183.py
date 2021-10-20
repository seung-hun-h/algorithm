from sys import stdin
from collections import defaultdict
import heapq

readline = stdin.readline

N, M, A, B, C = map(int, readline().split())
graph = defaultdict(list)
costs = set()

for _ in range(M):
    n, m, c = map(int, readline().split())
    graph[n].append((m, c))
    graph[m].append((n, c))

    costs.add(c)

def solve():
    global costs

    costs = list(sorted(costs))

    left, right = -1, len(costs)

    while left + 1 < right:
        mid = left + (right - left) // 2

        if dijkstra(costs[mid]):
            right = mid
        else:
            left = mid

    print(costs[right] if right != len(costs) else -1)

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