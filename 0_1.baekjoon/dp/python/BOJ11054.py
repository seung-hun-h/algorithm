from sys import stdin
from collections import defaultdict

readline = stdin.readline

N = int(readline())
nums = list(map(int, readline().split()))

def solve():
    lis = get_lis(nums)
    lis_reverse = get_lis(nums[::-1])

    print(max([lis[i] + lis_reverse[N-i-1] - 1 for i in range(N)]))

def get_lis(arr):
    dp = defaultdict(int)

    for i in range(N):
        dp[i] = 1
        for j in range(i):
            if arr[i] > arr[j]:
                dp[i] = max(dp[i], dp[j]+1)

    return dp

solve()