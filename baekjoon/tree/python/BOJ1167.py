from sys import stdin  
from collections import defaultdict
readline = stdin.readline

N = int(readline())
tree = defaultdict(list)
leaf = 0
_max = 0

for _ in range(N):
    line = list(map(int, readline().split()))

    for i in range(1, len(line), 2):
        if i+1 < len(line):
            tree[line[0]].append([line[i], line[i+1]])

def solve():
    visited = set()

    dfs(2, visited, 0)
    visited.clear()
    dfs(leaf, visited, 0)
    print(_max)

def dfs(node, visited, value):
    global _max, leaf

    visited.add(node)

    if value > _max:
        _max = value
        leaf = node

    for adj, weight in tree[node]:
        if adj not in visited:
            dfs(adj, visited, value + weight)



solve()