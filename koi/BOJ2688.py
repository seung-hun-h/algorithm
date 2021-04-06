from sys import stdin
from collections import deque
readline = stdin.readline

N = int(readline().strip())
array = [0] + [int(readline().strip()) for _ in range(N)]
visited = [False] * (N+1)
ans = 0

def solve():
    for i in range(1, N+1):
        q = deque()
        if not visited[i]:
            visited[i] = True
            if not dfs(i, i, 1, q):
                while q:
                    visited[q.popleft()] = False

    print(ans)
    for i in range(1, N+1):
        if visited[i]:
            print(i)

def dfs(startIdx, idx, cnt, q):
    global ans
    visited[idx] = True
    q.append(idx)

    _next = array[idx]

    if startIdx == _next:
        ans += cnt
        return True
    
    if not visited[_next]:
        return dfs(startIdx, _next, cnt+1, q)

    return False

solve()