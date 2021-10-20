from sys import stdin
import math
from collections import defaultdict
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    dp = defaultdict(int)
    dp[0] = arr[0]
    for i in range(1, N):
        if i < len(arr):
            dp[i] = arr[i]
        for j in range(math.ceil(i/2)):
            dp[i] = max(dp[i], dp[i-j-1] + dp[j])

    print(dp[N-1])
solve()