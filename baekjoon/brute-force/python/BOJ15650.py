from sys import stdin
from itertools import combinations

readline = stdin.readline

N, M = map(int, readline().split())

def solve():
    for combination in combinations(range(1, N + 1), M):
        print(*combination)

solve()