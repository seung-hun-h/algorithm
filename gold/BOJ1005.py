import sys
from sys import stdin
from collections import deque

readline = stdin.readline


def get_min_times():
    for i in range(N):
        if _in[i] == 0:
            dp[i] = max(dp[i], times[i])
            bfs(i)

    print(dp[target])

def bfs(start):
    q = deque()
    q.append(start)
    
    while q:
        
        u = q.popleft()
        if u == target:
            break

        for adj in graph[u]:
            _in[adj] -= 1
            dp[adj] = max(dp[adj], dp[u] + times[adj])
            if not _in[adj]:
                q.append(adj)


if __name__=="__main__":
    # 이전의 작업이 모두 끝난 후에 현재 일 진행 >> 위상정렬
    # 최소한의 값 >> 그리디
    # 동일한 LEVEL의 노드 중 긴 시간 선택 >> 다이나믹 프로그래밍
    T = int(readline().strip())
    for _ in range(T):
        N, K = map(int, readline().split())
        times = list(map(int, readline().split()))
        graph = [[] for _ in range(N)]

        _in = [0] * N
        dp = [0] * N

        for _ in range(K):
            u, v = map(int, readline().split())
            _in[v-1] += 1
            graph[u-1].append(v-1)
        
        target = int(readline().strip()) - 1

        get_min_times()
