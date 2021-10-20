from sys import stdin
from collections import deque

readline = stdin.readline

N, M = map(int, readline().split())
INF = 100001

def solve():
    visited = [False for _ in range(INF)]
    q = deque()
    q.append((N, 0))

    while q:
        v, w = q.popleft()

        if v == M:
            print(w)
            return

        if v * 2 < INF and not visited[v * 2]:
            visited[v * 2] = True
            q.appendleft((v * 2, w))

        if v + 1 < INF and not visited[v + 1]:
            visited[v + 1] = True
            q.append((v + 1, w + 1))
            
        if v - 1 >= 0 and not visited[v - 1]:
            visited[v - 1] = True
            q.append((v - 1, w + 1))
            

solve()