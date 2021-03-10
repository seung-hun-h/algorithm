import sys;input=sys.stdin.readline

n=int(input())
adj=[list(map(int,input().split())) for i in range(n)]
cpl=(1<<n)-1
INF=1<<30

def solve(cur,visited):
    if visited==cpl:
        return adj[cur][start] or INF
    if DP[cur][visited]: return DP[cur][visited]
    ans=INF
    for i in range(n):
        if adj[cur][i] and not visited&(1<<i):
            ans=min(ans, solve(i,visited|(1<<i))+adj[cur][i])
    DP[cur][visited]=ans
    return ans

ans=INF;start=0
DP=[[0]*(1<<n) for _ in range(n)]
ans=min(ans, solve(start,1<<start))
print(ans)

for a in DP:
    print(a)