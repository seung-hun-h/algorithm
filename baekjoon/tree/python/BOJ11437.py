from sys import stdin
from collections import defaultdict

readline = stdin.readline

N = int(readline())
tree = defaultdict(list)
parent = defaultdict(int)
nodes_depth = defaultdict(int)

def solve():
    for _ in range(N - 1):
        n, m = map(int, readline().split())
        tree[n].append(m)
        tree[m].append(n)

    dfs(1, 1)

    M = int(readline())

    for _ in range(M):
        n, m = map(int, readline().split())
        print(lca(n, m))

def lca(n, m):

    while nodes_depth[n] != nodes_depth[m]:
        if nodes_depth[n] > nodes_depth[m]:
            n = parent[n]
        else:
            m = parent[m]

    while n != m:
        n = parent[n]
        m = parent[m]

    return m

def dfs(node, depth):
    nodes_depth[node] = depth

    for adj in tree[node]:
        if adj not in nodes_depth:
            parent[adj] = node
            dfs(adj, depth + 1)
solve()