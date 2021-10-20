from sys import stdin
from collections import defaultdict, deque
readline = stdin.readline

N, M, A, B, C = map(int, readline().split())
graph = defaultdict(list)
INF = float('inf')
ans = INF


def solve():

    for _ in range(M):
        n, m, c = map(int, readline().split())

        graph[n].append((m, c))
        graph[m].append((n, c))

    # bfs()
    dfs(A, 0, C, 1 << A)
    print(ans if ans != INF else -1)

def bfs():
    global ans
    q = deque()

    q.append((A, 0, C, 1 << A))

    while q:
        node, max_cost, remain, visited = q.popleft();

        if ans <= max_cost: continue

        if node == B:
            ans = min(ans, max_cost)

        for adj, cost in graph[node]:

            if visited & (1 << adj) != 0: continue

            if remain - cost < 0: continue

            q.append((adj, max(max_cost, cost), remain - cost, visited | (1 << adj)))


def dfs(node, max_cost, remain, visited):
    global ans

    if ans <= max_cost:
        return
    
    if node == B:
        ans = min(ans, max_cost)
        return

    if visited == (1 << N) - 1:
        return

    for adj, cost in graph[node]:

        if visited & (1 << adj) != 0: continue

        if remain - cost < 0: continue

        dfs(adj, max(max_cost, cost), remain - cost, visited | (1 << adj))

solve()