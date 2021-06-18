from sys import stdin
import collections

readline = stdin.readline

N, K = map(int, readline().split())
coins = [int(readline()) for _ in range(N)]

def solve():
    dp = collections.defaultdict(int)
    dp[0] = 1

    for coin in coins:
        for i in range(coin, K+1):
            dp[i] += dp[i-coin]

    print(dp[K])

solve()