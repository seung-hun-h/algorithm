from sys import stdin
from collections import defaultdict
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    dp = defaultdict(int) # i까지 증가하는 부분 수열의 최대값
    
    for i in range(N):
        dp[i] = arr[i]
        here = 0
        for j in range(0, i):
            if arr[i] > arr[j]:
                here = max(here, dp[j])
        
        dp[i] += here

    print(max(dp.values()))
solve()