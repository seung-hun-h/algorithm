from sys import stdin, setrecursionlimit
from collections import defaultdict
readline = stdin.readline
setrecursionlimit(10 ** 6)

T = int(readline()) 

def solve():
    for _ in range(T):
        N = int(readline())
        graph = defaultdict(int)

        for u, v in enumerate(map(int, readline().split())):
            graph[u+1] = v
        
        visited = set()
        traced = set()
        cnt = 0
        for u in graph:
            if u not in visited:
                dfs(graph, u, visited, traced)
                cnt += 1
        print(cnt)

def dfs(graph, u, visited, traced):
    if u in traced:
        return
    if u in visited:
        return

    traced.add(u)
    visited.add(u)
    dfs(graph, graph[u], visited, traced)

    traced.remove(u)

solve()