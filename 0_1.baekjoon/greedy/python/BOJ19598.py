from sys import stdin
import heapq

readline = stdin.readline

N = int(readline())
meetings = [list(map(int, readline().split())) for _ in range(N)]

def solve():
    meetings.sort(key = lambda x : x[0])
    pq = []

    for meeting in meetings:

        if pq and pq[0] <= meeting[0]:
            heapq.heappop(pq)
        heapq.heappush(pq, meeting[1])

    print(len(pq))
    
solve()