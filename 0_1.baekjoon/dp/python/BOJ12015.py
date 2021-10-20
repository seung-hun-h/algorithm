from sys import stdin
from bisect import bisect_left

readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    ans = 1
    lis = [arr[0]]

    for num in arr[1:]:
        if lis[-1] < num:
            lis.append(num)
            ans += 1
        else:
            lis[bisect_left(lis, num)] = num

    print(ans)
solve()