from sys import stdin
from itertools import combinations_with_replacement

readline = stdin.readline

N, M = map(int, readline().split())

def solve():
    for combination in combinations_with_replacement(range(1, N + 1), M):
        print(*combination)

solve()