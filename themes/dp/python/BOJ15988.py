from sys import stdin

readline = stdin.readline

T = int(readline())

def solve():
    dp = [0, 1, 2, 4]
    MOD = 1000000009
    for _ in range(T):
        n = int(readline())

        if n < len(dp):
            print(dp[n] % MOD)
            continue

        for i in range(len(dp), n+1):
            dp.append((dp[-1] + dp[-2] + dp[-3]) % MOD)
        
        print(dp[n] % MOD)

solve()