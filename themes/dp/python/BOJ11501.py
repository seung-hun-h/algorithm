from sys import stdin
readline = stdin.readline

N, K = map(int, readline().split())
MOD = 10007

def solve():
    dp = [[0 for _ in range(K+1)] for _ in range(N+1)]

    for i in range(N+1):
        dp[i][0] = 1
        if i <= K:
            dp[i][i] = 1
        for j in range(1, K+1):
            if j == i: continue

            dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % MOD
    
    print(dp[-1][-1] % MOD)

solve() 
