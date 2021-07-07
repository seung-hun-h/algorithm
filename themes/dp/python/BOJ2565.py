from sys import stdin
from collections import defaultdict
readline = stdin.readline

N = int(readline())
seq = sorted([list(map(int, readline().split())) for _ in range(N)], key=lambda x : x[0])

def solve():
    dp = defaultdict(int)
    dp[0] = 1

    for i in range(N):
        here = 0
        for j in range(0, i):
            if seq[i][1] > seq[j][1]:
                here = max(here, dp[j])

        dp[i] = here + 1

    print(N - max(dp.values()))
    

solve()