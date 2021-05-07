from sys import stdin, setrecursionlimit
readline = stdin.readline
setrecursionlimit(10 ** 6)

T = int(readline())

def solve():
    for _ in range(T):
        n = int(readline())
        graph = dict()

        for u, v in enumerate(map(int, readline().split())):
            graph[u+1] = v

        visited = set()
        traced = set()
        done = set()

        for u in graph:
            if u not in visited:
                dfs(graph, u, traced, visited, done)

        print(n-len(done))    

def dfs(graph, u, traced, visited, done):
    # Cycle 발생
    if u in traced:
        done.add(u)
        _next = graph[u]
        while u != _next:
            done.add(_next)
            _next = graph[_next]
        return

    # 이미 방문한 노드
    if u in visited:
        return
    
    traced.add(u)
    visited.add(u)
    dfs(graph, graph[u], traced, visited, done)

    traced.remove(u)

def solve2():
    for _ in range(T):
        N = int(readline())
        visited = [False] * (N+1)
        graph = dict()

        for u, v in enumerate(map(int, readline().split())):
            graph[u+1] = v
        cnt = 0
        for u in graph:
            if visited[u]:
                continue

            cur = u
            while not visited[cur]:
                visited[cur] = True
                cur = graph[cur]
            
            start = u
            while start != cur:
                cnt += 1
                start = graph[start]
        print(cnt)
solve2()