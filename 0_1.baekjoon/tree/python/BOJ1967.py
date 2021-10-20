from sys import stdin, setrecursionlimit
from collections import defaultdict
readline = stdin.readline
setrecursionlimit(10 ** 6)

ans = 0
def solve():
    N = int(readline())
    tree = defaultdict(list)
    for _ in range(N-1):
        u, v, w = map(int, readline().split())
        tree[u].append([v, w])

    dfs(tree, 1)
    print(ans)

def dfs(tree, node):
    global ans
    if not tree[node]:
        return 0
    
    temp_weights = sorted([w+dfs(tree, v) for v, w in tree[node]], reverse=True)
    if len(temp_weights) >= 2:
        ans = max(ans, temp_weights[0] + temp_weights[1])
    elif temp_weights:
        ans = max(ans, temp_weights[0])    
    return temp_weights[0]

solve()