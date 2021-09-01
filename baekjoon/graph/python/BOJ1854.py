from sys import stdin
from collections import defaultdict
import heapq
readline = stdin.readline

n, m, k = map(int, readline().split())
graph = defaultdict(list)

for _ in range(m):
    u, v, t = map(int, readline().split())
    graph[u].append((v, t))

def solve():
    times = defaultdict(int)
    counts = defaultdict(int)
    q = [(0, 1)]
    while q:
        time, node = heapq.heappop(q)
        if node in times: continue
        counts[node] += 1
    
        if counts[node] == k:
            times[node] = time

        if len(times) == n: break

        if counts[node] <= k:
            for v, t in graph[node]:
                if v not in times:
                    alt = time + t
                    heapq.heappush(q, (alt, v))

    for i in range(1, n+1):
        if i not in times:
            print(-1)
        else:
            print(times[i])
solve()
