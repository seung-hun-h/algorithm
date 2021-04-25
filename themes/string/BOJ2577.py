from sys import stdin
readline = stdin.readline

def solve():
    mul = 1
    for _ in range(3):
        mul *= int(readline())

    str_mul = str(mul)
    
    for i in range(10):
        print(str_mul.count(str(i)))

solve()
