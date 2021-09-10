from sys import stdin, setrecursionlimit
from collections import defaultdict
setrecursionlimit(10 ** 6)


readline = stdin.readline
LOG = 21

N = int(readline())
tree = defaultdict(list)
parent = [[0 for _ in range(LOG)] for _ in range(N + 1)]
nodes_depth = defaultdict(int)

def solve():
    for _ in range(N - 1):
        n, m = map(int, readline().split())
        tree[n].append(m)
        tree[m].append(n)

    set_parent()

    M = int(readline())

    for _ in range(M):
        n, m = map(int, readline().split())
        print(lca(n, m))

def lca(n, m):

    if nodes_depth[n] < nodes_depth[m]:
        n, m = m, n

    for i in range(LOG - 1, -1, -1):
        if nodes_depth[n] - nodes_depth[m] >= (1 << i):
            n = parent[n][i]

    if n == m:
        return n

    for i in range(LOG - 1, -1, -1):
        
        if parent[n][i] != parent[m][i]:
            n = parent[n][i]
            m = parent[m][i]

    return parent[n][0]

def set_parent():
    dfs(1, 1)

    for d in range(1, LOG):
        for node in range(1, N + 1):
            parent[node][d] = parent[parent[node][d - 1]][d - 1]

def dfs(node, depth):
    nodes_depth[node] = depth

    for adj in tree[node]:
        if adj not in nodes_depth:
            parent[adj][0] = node
            dfs(adj, depth + 1)
solve()