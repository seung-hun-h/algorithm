from typing import *
import collections
import heapq
def findCheapestPrice(n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
    graph = collections.defaultdict(list)
    for u, v, w in flights:
        graph[u].append([v, w])

    dist = [float('inf') for _ in range(n)]
    # 가격, 정점, 남은 경유지 수
    q = collections.deque()
    q.append((0, src, k))
    dist[src] = 0
    while q:
        price, node, K = q.popleft()
        if K >= 0 :
            for v, w in graph[node]:
                alt = price + w
                if dist[v] > alt:
                    dist[v] = alt
                    q.append([alt, v, K-1])

    return -1 if dist[dst] == float('inf') else dist[dst]
    
f = [[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
res = findCheapestPrice(n = 5, flights = f, src = 0, dst = 2, k = 2)
print(res)
"""
5
[[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
0
2
2
"""