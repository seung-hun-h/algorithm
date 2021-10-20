from sys import stdin
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    cnt = 0
    arr.sort()
    for i in range(len(arr)):
        if binary_search(i, arr[i]):
            cnt += 1
    print(cnt)

def binary_search(i, target):
    temp = arr[:i] + arr[i+1:]
    left = 0
    right = N - 2
    while left < right:
        cur = temp[left] + temp[right]
        if cur > target:
            right -= 1
        elif cur < target:
            left += 1
        else:
            return True

    return False

solve()