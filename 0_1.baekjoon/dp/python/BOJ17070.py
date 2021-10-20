from sys import stdin
readline = stdin.readline

N = int(readline())
arr = [list(map(int, readline().split())) for _ in range(N)]

def solve():
    dp = [[[0 for _ in range(N)] for _ in range(N)] for _ in range(3)]

    dp[0][0][1] = 1

    for i in range(N):
        for j in range(N):
            if (arr[i][j] == 1 or (i == 0 and j == 1)): continue

            if j - 1 >= 0:
                dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1]

            if i - 1 >= 0:
                dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j]

            if i - 1 >= 0 and j - 1 >= 0:
                if arr[i-1][j] != 1 and arr[i][j-1] != 1:
                    dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1]

    print(dp[0][-1][-1] + dp[1][-1][-1] + dp[2][-1][-1])
solve()