from sys import stdin
import heapq
readline = stdin.readline

N = int(readline())
cards = [int(readline()) for _ in range(N)]

def solve():
    _sum = 0
    heapq.heapify(cards)
    while len(cards) >= 2:
        c1, c2 = heapq.heappop(cards), heapq.heappop(cards) 
        _sum += c1 + c2
        heapq.heappush(cards, c1+c2)
    
    print(_sum)

solve()
"""
해결: O
시간: 5분
13975번 문제와 유사했다.
"""