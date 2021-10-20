from sys import stdin
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))
exist = [False] * 2001

def solve():
    for num in arr:
        exist[1000+num] = True

    for i in range(2001):
        if exist[i]:
            print(i-1000, end=" ")
solve()