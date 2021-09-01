from sys import stdin
from collections import defaultdict

readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    dp = defaultdict(int)    
    for i, num in enumerate(arr):
        here = 0
        for j in range(0, i):
            if num > arr[j]:
                here = max(here, dp[j])

        dp[i] = here + 1
    
    length = max(dp.values())
    print(length)

    lis = []
    for key in sorted(dp, reverse=True):
        if dp[key] == length:
            lis.append(arr[key])
            length -= 1

    print(*list(reversed(lis)))
        
solve()