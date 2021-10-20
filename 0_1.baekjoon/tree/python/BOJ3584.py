from sys import stdin, setrecursionlimit
from collections import defaultdict, deque
readline = stdin.readline
setrecursionlimit(10 ** 6)

T = int(readline())
def solve():
    for _ in range(T):
        N = int(readline())
        reverse_tree = defaultdict(int)
        for _ in range(N-1):
            u, v = map(int, readline().split())
            reverse_tree[v] = u
        
        t1, t2 = map(int, readline().split())


        path1 = dfs(reverse_tree, t1, [])
        path2 = dfs(reverse_tree, t2, [])

        search_path = path1 if len(path1) < len(path2) else path2
        check_path = set(path2) if len(path1) < len(path2) else set(path1)

        for node in search_path:
            if node in check_path:
                print(node)
                break

def dfs(tree, node, path):
    path.append(node)

    if not tree[node]:
        return path
    
    return dfs(tree, tree[node], path)
solve()