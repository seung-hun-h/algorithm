from sys import stdin
readline = stdin.readline

N = int(readline())
MOD = 15746

def solve():
    if N <= 3:
        print(N)
        return
    
    prev, current = 1, 2
    for _ in range(3, N+1):
        prev, current = current, (prev + current) % MOD
    print(current)

solve()