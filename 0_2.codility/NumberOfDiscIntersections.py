# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
from collections import defaultdict
import heapq
def solution(A):
    # write your code in Python 3.6
    radiuses = []
    for i, r in enumerate(A):
        radiuses.append([i-r, r+i])

    radiuses.sort(key=lambda x: x[0])
    count = defaultdict(int)
    pq = []

    for i, [s, e] in enumerate(radiuses):
        while pq and pq[0][0] < s:
            end, idx = heapq.heappop(pq)
            count[idx] = i - idx - 1
        heapq.heappush(pq, [e, i])
    
    while pq:
        end, idx = heapq.heappop(pq)
        count[idx] = len(radiuses) - idx - 1
        
    result = sum(count.values())

    return result if result <= 10000000 else -1