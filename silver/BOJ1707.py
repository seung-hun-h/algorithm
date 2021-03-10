from sys import stdin
from collections import deque

readline = stdin.readline


def is_bipartition():
    V, E = map(int, readline().split())
    graph = [[] for _ in range(V+1)]
    visited  = [False] * (V+1)
    
    for _ in range(E):
        u, v = map(int, readline().split())
        graph[u].append(v)
        graph[v].append(u)

    # 연결, 비연결 그래프 모두 고려
    # 모든 노드를 방문해야한다.
    for i in range(1, V+1):
        if not visited[i]:
            ans = bfs(graph, visited, i)
            if not ans:
                return False

    return True

def bfs(graph, visited, start):
    q = deque()
    q.append(start)
    # 노드에 색을 칠함
    black = [False for _ in range(len(graph))]
    
    black[start] = True
    visited[start] = True

    while q:
        u = q.popleft()
    
        for adj in graph[u]:
            if not visited[adj]:
                q.append(adj)
                # 방문하지 않은 노드의 경우
                # 부모 노드와 다른 색을 칠한다.
                black[adj] = not black[u]
                visited[adj] = True
                continue
            # 만약 인접한 노드중 이미 방문한 노드가
            # 현재 노드와 색이 같을 경우
            # 이분 그래프가 될 수 없다.
            if visited[adj] and black[u] == black[adj]:
                return False

    return True


if __name__ == "__main__":
    K = int(readline().strip())
    for _ in range(K):
        if is_bipartition():
            print("YES")
        else:
            print("NO")