from sys import stdin
import heapq
readline = stdin.readline

N, X = map(int, readline().split())
gifts = list(map(int, readline().split()))

def solve():
    left, right = 0, N

    while left + 1 < right:
        mid = left + (right - left) // 2

        if get_production_time(mid) > X:
            left = mid
        else:
            right = mid

    print(right)

def get_production_time(limit):
    lines = gifts[:limit]
    heapq.heapify(lines)

    result = 0
    idx = limit

    while lines:
        current = heapq.heappop(lines)

        result = max(result, current)

        if idx < N:
            heapq.heappush(lines, current + gifts[idx])
            idx += 1

    return result

solve()