from sys import stdin
readline = stdin.readline

N, H = map(int, readline().split())


def solve():
    min_cnt = 1000000000000000
    cnt = 0
    up, down = [], []
    for i in range(N):
        n = int(readline())
        if i % 2 == 0:
            down.append(n)
        else:
            up.append(n)

    up.sort()
    down.sort()

    for i in range(1, H+1):
        # i 이상인 경우 파괴
        up_count = len(up) - binary_search(up, H-i)
        down_count = len(down) - binary_search(down, i-1)

        if min_cnt > up_count+down_count:
            min_cnt = up_count+down_count
            cnt = 1
        elif min_cnt == up_count+down_count:
            cnt += 1


    print(min_cnt, cnt)

def binary_search(arr, target):
    left, right = 0, len(arr) - 1 
    while left <= right:
        mid = (left + right) // 2

        if arr[mid] <= target:
            left = mid + 1
        else:
            right = mid - 1
    return left

solve()