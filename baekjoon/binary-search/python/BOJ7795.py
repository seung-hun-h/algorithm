from sys import stdin  
readline = stdin.readline

T = int(readline())

def solve():
    for _ in range(T):
        N, M = map(int, readline().split())
        A = list(sorted(list(map(int, readline().split()))))
        B = list(sorted(list(map(int, readline().split()))))
        print(count_pair(A, B))

def count_pair(A, B):
    cnt = 0
    for b in B:
        res = 0
        left = 0
        right = len(A)-1
        while left <= right:
            mid = (left+right) // 2
            if A[mid] > b:
                res = len(A) - mid
                right = mid - 1
            else:
                left = mid + 1

        cnt += res
    return cnt
     


solve()