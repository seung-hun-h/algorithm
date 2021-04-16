from sys import stdin
readline = stdin.readline

N, K = map(int, readline().split())

def solve():
    dp = [[0 for _ in range(201)] for _ in range(201)]

    for i in range(1, 201):
        dp[0][i] = 1
        dp[1][i] = i

    for n in range(2, 201):
        dp[n][1] = 1
        dp[n][2] = n+1
        for k in range(2, 201):
            dp[n][k] = (dp[n][k-1] + dp[n-1][k]) % 1000000000

    print(dp[N][K] % 1000000000)

solve()