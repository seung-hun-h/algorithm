from sys import stdin
from collections import defaultdict

readline = stdin.readline

T = int(readline())

def solve():
    for _ in range(T):
        print(merge_files())

def merge_files():
    N = int(readline())
    files = list(map(int, readline().split()))

    acc = accumulate(files)
    dp = [[0 for _ in range(N)] for _ in range(N)]

    for step in range(1, N):
        for start in range(N-step):
            end = start + step
            dp[start][end] = float('inf')
            for j in range(start, end):
                dp[start][end] = min(
                    dp[start][end], 
                    dp[start][j] + dp[j+1][end] + acc[end] - acc[start-1])
    
    return dp[0][N-1]

def accumulate(arr):
    res = defaultdict(int)
    for i in range(len(arr)):
        res[i] = res[i-1] + arr[i]

    return res

solve()