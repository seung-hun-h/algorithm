from collections import deque

def solution(a, edges):
    _sum = sum(list(a))
    if _sum != 0: return -1
    graph = [[] for _ in range(len(a))]
    cnt = [0] * len(a)
    
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)
    
    ans = 10000000000000
    for i in range(len(a)):
        ans = min(ans, bfs(i, a, graph))
    return ans

def bfs(start, a, graph):
    visited = [False] * len(a)
    visited[start] = True
    q = deque()
    q.append(start)
    temp = [a[i] for i in range(len(a))]
    while q:
        v = q.popleft()
    
        for adj in graph[v]:
            if not visited[adj]:
                visited[adj] = True
                temp[v] += a[adj]
    return sum(list(map(abs, temp)))