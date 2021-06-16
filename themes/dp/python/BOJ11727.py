from sys import stdin
readline = stdin.readline

N = int(readline())

def solve():
    if N == 1:
        return 1
    elif N == 2:
        return 3
    
    prev = 1
    current = 3
    for _ in range(3, N+1):
        _next = (current + prev*2) % 10007
        prev = current % 10007
        current = _next % 10007

    return current % 10007

print(solve())