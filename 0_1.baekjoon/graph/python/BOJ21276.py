from sys import stdin
from collections import defaultdict, deque
readline = stdin.readline

N = int(readline())
names = sorted(readline().split())
M = int(readline())
graph = defaultdict(list)
tree = defaultdict(list)
in_degree = defaultdict(int)

def solve():

    for _ in range(M):
        u, v = readline().split()

        graph[v].append(u)
        in_degree[u] += 1

    roots = [name for name in names if name not in in_degree]

    print(len(roots))
    print(*roots)

    for root in roots:
        topology_sort(root)

    for name in names:
        print(name, len(tree[name]), *sorted(tree[name]))



def topology_sort(root):

    q = deque()
    q.append(root)

    while q:
        node = q.popleft()

        for child in graph[node]:
            in_degree[child] -= 1

            if not in_degree[child]:
                tree[node].append(child)
                q.append(child)

solve()
