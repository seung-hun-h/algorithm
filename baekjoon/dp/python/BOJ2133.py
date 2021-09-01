from sys import stdin
from collections import defaultdict
readline = stdin.readline

N = int(readline())

def solve():
    if N % 2 == 1:
        print(0)
        return

    dp = defaultdict(int)
    dp[0], dp[2] = 1, 3

    for i in range(4, N+1):
        dp[i] = dp[i-2] * 3
        for j in range(4, i+1, 2):
            dp[i] += dp[i-j] * 2
    
    print(dp[N])
solve()