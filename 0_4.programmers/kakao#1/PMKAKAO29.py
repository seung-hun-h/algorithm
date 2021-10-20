from collections import defaultdict
import heapq
def solution(stones, k):
    left, right = 1, max(stones)

    while left <= right:
        mid = (left + right) // 2
        cnt = 0
        arr = stones[:]
        for i in range(len(arr)):
            if arr[i] <= mid:
                arr[i] = 0

        for stone in arr:
            if stone == 0:
                cnt += 1
            else:
                cnt = 0
            
            if cnt == k:
                break

        if cnt == k:
            right = mid - 1
        else:
            left = mid + 1

    return left    

def solution2(stones, k):
    _min = 0
    max_heap = []
    count = defaultdict(int)
    for i in range(k):
        _min = max(_min, stones[i])
        count[stones[i]] += 1
        heapq.heappush(max_heap, -stones[i])

    front, rear = 1, k

    while rear < len(stones):
        # 기존 돌 제거
        # 카운트 1 감소
        count[stones[front-1]] -= 1
        # 윈도우 내 없는 숫자 제거
        while max_heap and count[-max_heap[0]] == 0:
            heapq.heappop(max_heap)
        
        # 돌 추가
        heapq.heappush(max_heap, -stones[rear])
        count[stones[rear]] += 1


        _min = min(_min, -max_heap[0])

        front += 1
        rear += 1

    return _min
res = solution2([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3)
print(res)