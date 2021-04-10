from sys import stdin
from collections import defaultdict
readline = stdin.readline

T = int(readline())
n = int(readline())
A = list(map(int, readline().split()))
m = int(readline())
B = list(map(int, readline().split()))

def solve():
    res = 0
    A_sum = defaultdict(int)
    for i in range(n):
        _sum = 0
        for j in range(i, n):
            _sum += A[j]
            A_sum[_sum] += 1

    for i in range(m):
        _sum = 0
        for j in range(i, m):
            _sum += B[j]
            key = T-_sum
            res += A_sum[key]

    return res

print(solve())
