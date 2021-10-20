from sys import stdin
import collections
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    dp = collections.defaultdict(int)
    dp[arr[0]] = 1
    
    for index in range(1, N-1):
        new_dp = collections.defaultdict(int)
        for current in dp:
            n1, n2 = current + arr[index], current - arr[index]

            if 0 <= n1 <= 20:        
                new_dp[n1] += dp[current]
            if 0 <= n2 <= 20:        
                new_dp[n2] += dp[current]
        dp = new_dp
    print(dp[arr[-1]])
solve()

"""
해결: O
시간: 1시간 17분
"""