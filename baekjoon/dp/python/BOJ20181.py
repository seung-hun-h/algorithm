from sys import stdin
from collections import defaultdict
readline = stdin.readline

N, K = map(int, readline().split())
arr = list(map(int, readline().split()))
dp = defaultdict(int)

def solve():
    left, right, _sum = 0, 0, 0
    while right <= N:
        if _sum >= K:
            while _sum >= K:
                dp[right] = max(dp[right], dp[left] + _sum - K)
                _sum -= arr[left]
                left += 1
        else:
            dp[right] = max(dp[right], dp[right - 1])

            if right == N:
                break

            _sum += arr[right]
            right += 1     

    
    print(dp[N])

solve()