import sys
from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 6)
readline = stdin.readline

N = int(readline())
graph = [list(map(int,input().split())) for i in range(N)]
dp=[[0]*(1<<N) for _ in range(N)]
MAX = sys.maxsize


def TSP(cur, visited):
    # 모든 도시를 방문한 경우 
    # 현재 도시와 시작 도시간 경로가 있다면 해당 값을 반환
    if visited == ((1 << N) - 1):
        return graph[cur][0] or MAX

    # 이미 방문한 도시인 경우
    if dp[cur][visited]:
        return dp[cur][visited]
    
    cost = MAX
    for i in range(N):
        # cur과 i 도시간 경로가 존재하고
        # i 가 아직 방문하지 않은 도시라면
        if graph[cur][i] and not visited&(1<<i):
            cost = min(cost, TSP(i, visited|(1<<i))+ graph[cur][i])
    dp[cur][visited] = cost

    return cost

ans = TSP(0, 1)
if ans == MAX:
    print(-1)
else:
    print(ans)