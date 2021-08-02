from collections import defaultdict
import heapq

def solution(stones, k):
    ans, left, right = 0, 1, k
    counter = defaultdict(int)
    max_heap = []

    for i in range(k):
        counter[stones[i]] += 1
        ans = max(ans, stones[i])
        heapq.heappush(max_heap, -stones[i])

    while right < len(stones):
        counter[stones[left - 1]] -= 1

        while max_heap and counter[-max_heap[0]] == 0:
            heapq.heappop(max_heap)

        counter[stones[right]] += 1
        heapq.heappush(max_heap, -stones[right])

        ans = min(ans, -max_heap[0])

        right += 1
        left += 1
    print(ans)
    return ans

solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3)