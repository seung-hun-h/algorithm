from sys import stdin
from collections import defaultdict
readline = stdin.readline

N = int(readline())
nums = list(map(int, readline().split()))

def solve():
    lis = []
    ans = 0

    for num in nums:
        if not lis or lis[-1] < num:
            lis.append(num)
            ans += 1
            continue

        lis[lower_bound(lis, num)] = num
    
    print(ans)

def lower_bound(arr, target):
    left, right = 0, len(arr)

    while left < right:
        mid = left + (right - left) // 2

        if arr[mid] < target:
            left = mid + 1
        else:
            right = mid
    
    return right

solve()