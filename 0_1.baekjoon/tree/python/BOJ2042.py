from sys import stdin
from collections import defaultdict
readline = stdin.readline

N, M, K = map(int, readline().split())

arr = [int(readline().strip()) for _ in range(N)]
tree = defaultdict(int)

def solve():
    init(0, N-1, 1)

    for _ in range(M + K):
        a, b, c = map(int, readline().split())

        if a == 1:
            diff = c - arr[b - 1]
            arr[b - 1] = c
            update(0, N-1, 1, b - 1, diff)
        elif a == 2:
            print(_sum(0, N-1, 1, b-1, c-1))

def init(start, end, node):
    if start == end:
        tree[node] = arr[start]
        return tree[node]

    mid = (start + end) // 2
    tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1)
    return tree[node]

def _sum(start, end, node, left, right):
    if left > end or right < start:
        return 0
    
    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2
    return _sum(start, mid, node * 2, left, right) + _sum(mid + 1, end, node * 2 + 1, left, right)

def update(start, end, node, idx, diff):
    if idx < start or idx > end:
        return
    
    tree[node] += diff
    if start == end:
        return
    
    mid = (start + end) // 2
    update(start, mid, node * 2, idx, diff)
    update(mid + 1, end, node * 2 + 1, idx, diff)

solve()