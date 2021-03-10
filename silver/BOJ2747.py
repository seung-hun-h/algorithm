from sys import stdin
from collections import deque

readline = stdin.readline

def get_fibo():
    if n == 0:
        return 0
    elif n == 1 :
        return 1
    
    prev = 0
    cur = 1
    _next = prev + cur
    for _ in range(2, n+1):
        _next = cur + prev
        temp = cur
        cur = _next
        prev = temp
    
    return _next % 1000000

if __name__ == "__main__":
    n = int(readline().strip())
    print(get_fibo())