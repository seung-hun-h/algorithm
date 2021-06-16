"""
link = https://www.acmicpc.net/problem/20440
SOLVING : 50m 
CLEAR : X
IMPLEMENTATION: 15m
DEBUGING: 23m
"""

from sys import stdin
readline = stdin.readline

N = int(readline())


def solve():
    starts = []
    ends = []
    points = set()
    for _ in range(N):
        s, e = map(int, readline().split())
        starts.append(s)
        ends.append(e)
        points.add(s)
        points.add(e)

    points = list(sorted(list(points)))
    p_sum = [0] * len(points)

    for i in range(N):
        s, e = starts[i], ends[i]
        idx_s, idx_e = lower_bound(points, s), lower_bound(points, e)
        
        p_sum[idx_s] += 1
        p_sum[idx_e] -= 1

    for i in range(1, len(points)):
        p_sum[i] += p_sum[i-1]

    _max = 0
    _max_s = 0
    _max_e = 0

    flag = False
    for i in range(len(points)):
        if _max < p_sum[i]:
            _max = p_sum[i]
            _max_s = i
            flag = True

        if p_sum[i] == _max and flag:
            _max_e = i
            continue
            
        flag = False

    _max_e = _max_e + 1 if _max_e < len(points)-1 else _max_e
    print(_max)
    print(points[_max_s], points[_max_e])

def lower_bound(arr, target):
    left, right = 0, len(arr) - 1
    while left < right:
        mid = (left + right) // 2
        
        if arr[mid] < target:
            left = mid + 1
        else:
            right = mid
    return right

solve()


