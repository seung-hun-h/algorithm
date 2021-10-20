from sys import stdin
readline = stdin.readline


def solve():
    n, m = readline().strip().split()

    res = int(n[::-1]) + int(m[::-1])
    print(int(str(res)[::-1]))

solve()
