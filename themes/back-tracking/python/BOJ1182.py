from sys import stdin
readline = stdin.readline

N, S = map(int, readline().split())
arr = list(map(int, readline().split()))
cnt = 0

def solve():
    global cnt
    dfs(0, 0)
    if S == 0: # 공집합 제거
        cnt -= 1
    print(cnt)

def dfs(idx, _sum):
    global cnt
    if idx == N:
        if _sum == S:
            cnt += 1
        return
    dfs(idx+1, _sum + arr[idx])
    dfs(idx+1, _sum)

solve()