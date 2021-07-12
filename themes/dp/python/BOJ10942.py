from sys import stdin
readline = stdin.readline

N = int(readline())
nums = list(map(int, readline().split()))

def solve():
    dp = [[0 for _ in range(N)] for _ in range(N)]

    for start in range(N-1, -1, -1):
        for end in range(start, N):
            if start == end or (end - start == 1 and nums[start] == nums[end]):
                dp[start][end] = 1
                continue

            if nums[start] != nums[end]: continue

            dp[start][end] = dp[start+1][end-1]

    M = int(readline())

    for _ in range(M):
        start, end = map(int, readline().split())
        print(dp[start-1][end-1])
solve()