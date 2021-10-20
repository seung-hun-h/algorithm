from sys import stdin, setrecursionlimit
from collections import defaultdict
setrecursionlimit(10 ** 6)
readline = stdin.readline
N = int(readline())

def solve():
    graph = defaultdict(list)
    for _ in range(N-1):
        u, v = map(int, readline().split())
        graph[u].append(v)
        graph[v].append(u)

    parents = defaultdict(int)
    visited = set()
    prev = 0

    dfs(graph, 1, prev, parents, visited)
    
    for i in range(2, N+1):
        print(parents[i])

def dfs(graph, current, prev, parents, visited):
    visited.add(current)
    parents[current] = prev

    for adj in graph[current]:
        if adj not in visited:
            dfs(graph, adj, current, parents, visited)

solve()