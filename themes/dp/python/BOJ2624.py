from sys import stdin
import collections

readline = stdin.readline

T = int(readline())
K = int(readline())
counts = [list(map(int, readline().split())) for _ in range(K)]

def solve():
    dp =[[0 for _ in range(T+1)] for _ in range(K+1)]
    dp[0][0] = 1

    for i, (coin, limit) in enumerate(counts, 1):
        for k in range(T+1):
            dp[i][k] = dp[i-1][k]
        for count in range(1, limit+1):
            for money in range(coin*count, T+1):
                dp[i][money] += dp[i-1][money - coin * count]

    print(dp[-1][-1])

solve()
