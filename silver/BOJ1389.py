from sys import stdin, maxsize
import heapq

readline = stdin.readline

def get_min_kb():
    graph = [[] for _ in range(N+1)]

    for _ in range(M):
        u, v = map(int , readline().split())
        graph[u].append(v)
        graph[v].append(u)
    
    min_kb = 101
    min_idx = 0
    for i in range(1, N+1):
        temp = bfs(graph, i)      
        if temp < min_kb:
            min_idx = i
            min_kb = temp

    return min_idx

def bfs(graph, start):
    visited = [False] * (N+1)
    visited[start] = True
    ans = 0

    q = []
    heapq.heappush(q, [0, start])
    while q:
        w, u = heapq.heappop(q)
        visited[u] = True
        ans += w

        for adj in graph[u]:
            if not visited[adj]:

                visited[adj] = True
                heapq.heappush(q, [w+1, adj])

    return ans

if __name__ == "__main__":
    N, M = map(int, readline().split())

    print(get_min_kb())