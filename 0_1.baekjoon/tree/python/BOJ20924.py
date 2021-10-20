from sys import stdin, setrecursionlimit
from collections import defaultdict, deque
readline = stdin.readline
setrecursionlimit(10 ** 6)

N, root = map(int, readline().split())
tree = defaultdict(list)
for _ in range(N-1):
    u, v, c = map(int, readline().split())
    tree[u].append([v, c])
    tree[v].append([u, c])

longest = 0

def solve():
    col_length = get_col_length(root)
    dfs(root, set(), 0)
    print(col_length, longest-col_length)    

def dfs(node, visited, length):
    global longest
    longest = max(longest, length)

    visited.add(node)
    for u, c in tree[node]:
        if u not in visited:
            dfs(u, visited, length+c)

def get_col_length(root):
    if len(tree[root]) > 1:
        return 0

    length = 0
    q = deque([[root, length]])
    visited = set()
    visited.add(root)

    while q:
        node, length = q.popleft()

        if len(tree[node]) >= 3:
            return length

        for u, c in tree[node]:
            if u not in visited:
                visited.add(u)
                q.append([u, length+c])

    return length
solve()
