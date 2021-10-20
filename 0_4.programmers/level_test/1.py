def solution(n, money):
    dp = [0 for _ in range(n+1)]
    dp[0] = 1
    for m in money:
        for j in range(m, n+1):
            dp[j] += dp[j - m] % 1000000007
            
    return dp[-1] % 1000000007