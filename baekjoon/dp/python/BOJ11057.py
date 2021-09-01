from sys import stdin
readline = stdin.readline

N = int(readline())

def solve():
    dp = [1 for _ in range(10)]

    for _ in range(1, N):
        new_dp = [sum(dp)]
        for i in range(9):
            new_dp.append(new_dp[-1] - dp[i])

        dp = new_dp

    print(sum(dp) % 10007)
solve()