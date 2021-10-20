from typing import *
from collections import defaultdict
import heapq

def networkDelayTime(times: List[List[int]], n: int, k: int) -> int:
    graph = defaultdict(list)
    for u, v, t in times:
        graph[u].append((v, t))

    dist = defaultdict(int)
    q = [[0, k]]

    while q:
        time, node = heapq.heappop(q)

        if node not in dist:
            dist[node] = time
            for v, w in graph[node]:
                alt = time + w
                if v not in dist:
                    heapq.heappush(q, (alt, v))

    if len(dist) == n:
        return max(dist.values())
    return -1

res = networkDelayTime(times = [[1,2,1]], n = 2, k = 1)
print(res)