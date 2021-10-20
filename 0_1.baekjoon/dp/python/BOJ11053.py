from sys import stdin
from collections import defaultdict
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    dp = defaultdict(int)

    for i in range(N):
        here = 0
        for j in range(0, i):
            if arr[j] < arr[i]:
                here = max(here, dp[j])
        dp[i] = here+1
    
    print(max(dp.values()))
solve()