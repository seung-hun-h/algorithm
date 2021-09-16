from sys import stdin
from itertools import combinations

readline = stdin.readline

def solve():

    line = list(map(int, readline().split()))
    while  len(line) != 1:
        for combination in combinations(line[1:], 6):
            print(*combination)

        print()
        line = list(map(int, readline().split()))

solve()