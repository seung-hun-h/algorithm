from sys import stdin
readline = stdin.readline

N, M = map(int, readline().split())
A = set(map(int, readline().split()))
B = set(map(int, readline().split()))

def solve():
    diff = list(A - B)
    print(len(diff))
    print(" ".join(list(map(str, sorted(diff)))))
solve()