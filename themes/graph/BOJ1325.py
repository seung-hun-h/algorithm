from sys import stdin, setrecursionlimit
from collections import defaultdict, deque
readline = stdin.readline
setrecursionlimit(10 ** 6)

N, M = map(int, readline().split())
graph = defaultdict(list)

for _ in range(M):
    u, v = map(int, readline().split())
    graph[v].append(u)

def solve():
    max_cnt = 0
    spreaded = []
    for u in sorted(list(graph)):
        cur = bfs(graph, u)
        if cur < max_cnt: continue
        if cur == max_cnt:
            spreaded.append(u)
        elif cur > max_cnt:
            max_cnt = cur
            spreaded = [u]
    print(*spreaded)

def bfs(graph, start):
    visited = [False] * (N+1)
    q = deque()
    q.append(start)
    visited[start] = True
    cnt = 0
    while q:
        node = q.popleft()
        cnt += 1
        for v in graph[node]:
            if not visited[v]:
                visited[v] = True
                q.append(v)
    return cnt

def dfs(graph, node, visited):
    if not graph[node]:
        return 1

    visited.add(node)
    cur = 0
    for v in graph[node]:
        if v not in visited:
            cur += dfs(graph, v, visited) + 1

    return cur
solve()