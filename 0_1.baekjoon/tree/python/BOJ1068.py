from sys import stdin
from collections import defaultdict
readline = stdin.readline

N = int(readline())
arr = map(int, readline().split())
target = int(readline())


def solve():
    tree = defaultdict(list)
    start = 0
    for node, parent in enumerate(arr):
        if parent == -1:
            start = node
        else:
            tree[parent].append(node)

    if start == target:
        print(0)
    else:
        print(dfs(tree, start))
        
def dfs(tree, node):
    if not tree[node]:
        return 1
    
    leaves = 0
    for child in tree[node]:
        if child != target:
            leaves += dfs(tree, child)
        else:
            if len(tree[node]) == 1:
                leaves += 1
    return leaves
solve()