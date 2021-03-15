from sys import stdin
from itertools import permutations as perms
readline = stdin.readline

N = int(readline())
A, B = list(map(int, readline().split())), list(map(int, readline().split()))
ans = 100 * N + 1
A.sort(reverse=True)
B.sort()


def solve():
    global ans
    cur = 0
    for a, b in zip(A, B):
        cur += (a*b)
    print(cur)
solve()

