from sys import stdin
readline = stdin.readline

N = int(readline())
nums = [list(map(int, readline().split())) for _ in range(N)]

def solve():
    min_dp = [[0, 0, 0] for _ in range(2)]
    max_dp = [[0, 0, 0] for _ in range(2)]

    for i in range(N):
        max_dp[1][0] = max(max_dp[0][0], max_dp[0][1]) + nums[i][0]
        max_dp[1][1] = max(max_dp[0][0], max_dp[0][1], max_dp[0][2]) + nums[i][1]
        max_dp[1][2] = max(max_dp[0][1], max_dp[0][2]) + nums[i][2]

        min_dp[1][0] = min(min_dp[0][0], min_dp[0][1]) + nums[i][0]
        min_dp[1][1] = min(min_dp[0][0], min_dp[0][1], min_dp[0][2]) + nums[i][1]
        min_dp[1][2] = min(min_dp[0][1], min_dp[0][2]) + nums[i][2]

        max_dp[0] = max_dp[1][:]
        min_dp[0] = min_dp[1][:]

    print(max(max_dp[0]), min(min_dp[0]))
solve()