from sys import stdin
import heapq
readline = stdin.readline

N = int(readline())
lessons = [list(map(int, readline().split())) for _ in range(N)]

def solve():
    # 수업 시작 시간기준 오름차순 정렬
    lessons.sort(key = lambda x : x[0])

    pq = []
    for lesson in lessons:
        # 수업 시간이 겹치치 않을 경우 큐에서 제거
        if pq and pq[0] <= lesson[0]:
            heapq.heappop(pq)
        heapq.heappush(pq, lesson[1])

    print(len(pq)) 

solve()

"""
해결: x
시간: 50분
"""