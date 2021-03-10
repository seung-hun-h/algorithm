from sys import stdin, setrecursionlimit
readline = stdin.readline


def main():
    seq1 = readline().strip()
    seq2 = readline().strip()

    dp = [[0] * (len(seq2)+1) for _ in range(len(seq1) + 1)]


    for i in range(1, len(seq1)+1):
        for j in range(1, len(seq2)+1):
            if seq1[i-1] == seq2[j-1]:
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])

    print(d[len(seq1)][len(seq2)])

if __name__ == "__main__":
    main()