from sys import stdin
readline = stdin.readline

N = int(readline())
arr = [int(readline()) for _ in range(N)]

def solve():
    dp = [0 for _ in range(N)]

    for i in range(N):
        dp[i] = 1
        for j in range(0, i):
            if arr[i] > arr[j] and dp[i] < dp[j] + 1:
                dp[i] = dp[j] + 1

    print(N - max(dp))
solve()
"""
해결: X
시간: 46분
LIS 알고리즘으로 풀이가 가능하다!
"""