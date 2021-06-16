"""
link = https://www.acmicpc.net/problem/10986
SOLVING : 50m 
IMPLEMENTATION: 15m
DEBUGING: 23m
CLEAR : X
"""

from sys import stdin
readline = stdin.readline

N, M = map(int, readline().split())
arr = list(map(int, readline().split()))

def solve():
    ans = 0
    cnt = [0] * (M)
    p_sum = [0]
    for i in range(N):
        cur = p_sum[-1] + arr[i]
        p_sum.append(cur)

        if cur % M == 0:
            ans += 1

        cnt[cur%M] += 1

    for i in range(M):
        ans += (cnt[i] * (cnt[i] - 1)) // 2
    print(ans)

solve()