from sys import stdin
from itertools import combinations

readline = stdin.readline

L, C = map(int, readline().split())
vowel = {"a", "e", "i", "o", "u"}


def solve():
    chars = list(sorted(readline().split()))
    
    for combination in combinations(chars, L):
        result = "".join(combination)
        if check(result):
            print(result)

def check(string):
    count = 0
    for char in string:
        if char in vowel:
            count += 1

    return count >= 1 and len(string) - count >= 2

solve()