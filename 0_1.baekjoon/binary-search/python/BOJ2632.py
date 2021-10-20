from sys import stdin
from collections import defaultdict
readline = stdin.readline

T = int(readline())
N, M = map(int, readline().split())

A = [int(readline()) for _ in range(N)]
B = [int(readline()) for _ in range(M)]



def solve():
    stack_sum_A = list(sorted(get_stack_sum(A)))
    stack_sum_B = list(sorted(get_stack_sum(B)))

    A_count = get_count_as_dict(stack_sum_A)
    B_count = get_count_as_dict(stack_sum_B)

    res = binary_search(A_count, B_count)
    print(res)

def get_count_as_dict(arr):
    count = defaultdict(int)
    for a in arr:
        if a not in count.keys():
            count[a] = 0
        count[a] += 1
    return count

def binary_search(dict1, dict2):
    arr1 = list(sorted(list(dict1.keys())))
    arr2 = list(sorted(list(dict2.keys())))

    left, right = 0, len(arr2) - 1
    res = dict1[T] + dict2[T]
    while left < len(arr1) and right >= 0:
        cur = arr1[left] + arr2[right]

        if cur > T:
            right -= 1
        elif cur < T:
            left += 1
        else:
            res += (dict1[arr1[left]] * dict2[arr2[right]])
            left += 1
            right -= 1
    return res

# 누적합
# Circular
def get_stack_sum(arr):
    res = []
    start = 0
    end = len(arr) - 1
    # 순환 배열 누적합
    while True:
        _sum = 0
        i = start
        while i != end:
            _sum += arr[i]
            if _sum > T: break
            res.append(_sum)

            i = (i + len(arr) + 1) % len(arr)

        start = (start + len(arr) + 1) % len(arr)
        end = (start + len(arr) - 1) % len(arr)
        # 시작점이 다시 처음으로 돌아오면 종료
        if start == 0: break
    
    _sum = sum(arr)
    if _sum <= T:
        res.append(_sum)
    return res

solve()