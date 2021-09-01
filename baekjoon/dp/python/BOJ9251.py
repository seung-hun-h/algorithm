from sys import stdin
readline = stdin.readline

seq1, seq2 = readline().rstrip(), readline().rstrip()

def solve():
    dp = []
    for i in range(len(seq1)):
        max_len = 0
        for j in range(len(seq2)):
            if j >= len(dp):
                dp.append(max_len)

            if max_len < dp[j]:
                max_len = dp[j]
            elif seq1[i] == seq2[j]:
                dp[j] = max_len + 1  
    print(max(dp))

def solve2():

    dp = [[0] * (len(seq2)+1) for _ in range(len(seq1) + 1)]

    for i in range(1, len(seq1)+1):
        for j in range(1, len(seq2)+1):
            if seq1[i-1] == seq2[j-1]:
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])

    for d in dp:
        print(d)

solve2()

