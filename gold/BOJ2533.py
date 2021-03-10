from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 6)
readline = stdin.readline


N = int(readline())
tree = [[] for _ in range(N+1)]
dp = [[0, 1] for _ in range(N+1)] # 0: 노드가 얼리어답터가 아닐때, 1: 노드가 얼리어답터일 때
visited = [False] * (N+1)

for _ in range(1, N):
    u, v = map(int, readline().split())
    tree[u].append(v)
    tree[v].append(u)

def dfs(cur):
    visited[cur] = True
    
    for child in tree[cur]:
        if not visited[child]:
            dfs(child)
            # 현재 노드가 얼리어답터가 아닐 경우
            # 반드시 자식노드가 얼리어답터 이어야 한다. 
            dp[cur][0] += dp[child][1]
            # 현재 노드가 얼리어답터일 경우
            # 자식 노드는 얼리어답터일 수도 아닐 수도 있다.
            dp[cur][1] += min(dp[child])


dfs(1)
print(min(dp[1]))