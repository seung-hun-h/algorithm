from sys import stdin
readline = stdin.readline

N, K = map(int, readline().split())

def solve():
    dp = [[0 for _ in range(201)] for _ in range(201)]

    for i in range(1, K+1):
        dp[0][i] = 1

    for i in range(1, N+1):
        for j in range(1, K+1):
            if j == 1:
                dp[i][j] = 1
            elif j == 2:
                dp[i][j] = i+1
            else:
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000

    # print(dp[1])
    print(dp[N][K] % 1000000000)

solve()