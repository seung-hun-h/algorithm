from sys import stdin
readline = stdin.readline

N, M = map(int, readline().split())

def solve():
    dfs([], set())

def dfs(prefix, visited):
    if len(prefix) == M:
        print(*prefix)
        return

    for i in range(1, N+1):
        if i not in visited:
            visited.add(i)
            dfs(prefix+[i], visited)
            visited.remove(i)        
solve()