from sys import stdin
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    cnt = 0
    arr.sort()
    for num in arr:
        if binary_search(num):
            cnt += 1
    print(cnt)

def binary_search(target):
    left = 0
    right = N-1
    while left < right:
        mid = (left + right) // 2
        cur = arr[left] + arr[mid]
        if cur > target:
            right = mid - 1
        elif cur < target:
            left = mid + 1
        else:
            return True

    return False

solve()