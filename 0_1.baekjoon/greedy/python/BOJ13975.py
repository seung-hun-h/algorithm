from sys import stdin
import heapq
readline = stdin.readline

T = int(readline())

def solve():
    for _ in range(T):
        K = int(readline())
        chaps = list(map(int, readline().split()))
        sums = 0
        heapq.heapify(chaps)

        while len(chaps) >= 2:
            num1, num2 = heapq.heappop(chaps), heapq.heappop(chaps)
            sums += num1+num2
            heapq.heappush(chaps, num1+num2)
        
        print(sums)


solve()

"""
해결: O
시간: 18분
"""