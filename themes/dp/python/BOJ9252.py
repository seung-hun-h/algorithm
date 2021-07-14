from sys import stdin
from collections import defaultdict
readline = stdin.readline

seq1, seq2 = readline().strip(), readline().strip()
N, M = len(seq1), len(seq2)
def solve():
    dp = [["" for _ in range(M+1)] for _ in range(N+1)]
    for i in range(1, N+1):
        for j in range(1, M+1):
            if seq1[i-1] == seq2[j-1]:
                dp[i][j] = dp[i-1][j-1] + seq1[i-1]
            else:
                if len(dp[i-1][j]) > len(dp[i][j-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i][j-1]
    print(len(dp[-1][-1]))
    if dp[-1][-1]:
        print(dp[-1][-1])
solve()