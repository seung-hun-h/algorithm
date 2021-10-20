from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 9)
readline = stdin.readline

A, B, C = map(int, readline().split())

def solve():
    print(pow(A, B))

def pow(x, exponent):
    if exponent == 0:
        return 1
        
    temp = pow(x, exponent // 2)

    if exponent % 2 == 1:
        return (temp * temp % C) * x % C

    return temp * temp % C 
solve()