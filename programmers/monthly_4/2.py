import heapq

def solution(n, z, roads, queries):
    answer = []
    graph = [[] for _ in range(5)]
    
    for u, v, w in roads:
        graph[u].append([v, w])
    
    for q in queries:
        answer.append(bfs(n, z, graph, q))
    return answer

def bfs(n, z, graph, target):
    q = []
    heapq.heappush(q, [0, 0, 0])
    
    while q:
        turn, point, v = heapq.heappop(q)
        visited = [False for _ in range(n)]
        visited[v] = True
        if point == target:
            return turn
        
        if point > target:
            break
        
        for m, w in graph[v]:
            heapq.heappush(q, [turn+1, point+w, m])
            visited[m] = True
            
        heapq.heappush(q, [turn+1, point+z, v])
        for i in range(n):
            if not visited[i]:
                heapq.heappush(q, [turn+1, point, i])
    
    return -1