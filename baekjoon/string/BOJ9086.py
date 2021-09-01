from sys import stdin
readline = stdin.readline

N = int(readline())

def solve():
    for _ in range(N):
        line = readline().strip()
        print(f'{line[0]}{line[-1]}')

solve()