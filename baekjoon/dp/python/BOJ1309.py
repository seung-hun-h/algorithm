from sys import stdin
from collections import defaultdict
readline = stdin.readline

N = int(readline())

def solve():
    dp = defaultdict(int)
    dp[0] = 1
    dp[1] = 3

    for i in range(2, N+1):
        dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901

    print(dp[N])

    

solve()