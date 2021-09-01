from sys import stdin
readline = stdin.readline

N = int(readline())

def solve():
    for _ in range(N):
        line = readline().strip()
        print(line[0].upper()+line[1:])
solve()