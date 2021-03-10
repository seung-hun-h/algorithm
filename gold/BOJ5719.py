from sys import stdin
from collections import deque
import heapq

readline = stdin.readline

INF = 500 * 10 ** 3 + 1 

def get_almost_shortest():
    graph = [[] for _ in range(N)]

    for _ in range(M):
        u, v, c = map(int, readline().split())
        graph[u].append([c, v])

    pred_list, dist = dijikstra(graph)
    delete_path(graph, pred_list, dist)
    pred_list, dist = dijikstra(graph)

    return dist[end] if dist[end] < INF else -1
    
def delete_path(graph, pred_list, dist):
    q = deque()
    q.append(end)
    while q:
        n = q.popleft()
        # 해당 노드의 이전 노드 중
        for p in pred_list[n]:
            for i in range(len(graph[p])):
                # 최단 경로를 구성하는 경로 중 하나일 경우
                # 해당 비용을 무한대로 설정한다.
                if graph[p][i][1] == n and dist[n] == graph[p][i][0] + dist[p]:
                    graph[p][i][0] = INF
                    q.append(p)        
        

def dijikstra(graph):
    dist = [INF] * N
    dist[start] = 0
    pred_list = [[] for _ in range(N)]
    q = []
    heapq.heappush(q, [0, start])

    while q:
        w, u = heapq.heappop(q)
        if u == end:
            break
        if w > dist[u]:
            continue
        
        for _w, v in graph[u]:
            
            if dist[v] > dist[u] + _w:
                dist[v] = dist[u] + _w
                pred_list[v].append(u)
                heapq.heappush(q, [dist[v], v]) 

            if dist[v] == dist[u] + _w:
                pred_list[v].append(u)

    return pred_list, dist


def get_path(pred, start, end):
    path = []
    node = end
    while pred[node] != node:
        path.append(node)
        node = pred[node]
    path.append(node)    
    return list(reversed(path))

if __name__ == "__main__":
    N, M = map(int, readline().split())
    while not (N == 0 and M == 0):
        start, end = map(int, readline().split())
        print(get_almost_shortest())
        N, M = map(int, readline().split())