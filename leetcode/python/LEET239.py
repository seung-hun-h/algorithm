from typing import *
import collections

class Solution:

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        q = collections.deque()
        result = []

        for i, v in enumerate(nums):
            # out of window 제거
            if q and i - q[0] == k:
                q.popleft()

            # new item 보다 작은 원소 제거
            while q and nums[q[-1]] <= v:
                q.pop()

            q.append(i)

            # 윈도우 사이즈가 k만큼 커진 경우 출력
            if i >= k-1:
                result.append(nums[q[0]])

        return result
    
    def maxSlidingWindow2(self, nums: List[int], k: int) -> List[int]:
        q = collections.deque()
        result = []

        for i, v in enumerate(nums):
            # 새로운 아이템보다 작은 아이템 제거
            while q and q[-1] < v:
                q.pop()
            
            q.append(v)

            if i >= k-1:
                result.append(q[0])
                # 윈도우 사이즈를 벗어난 아이템 제거
                if nums[i-k+1] == q[0]:
                    q.popleft()
        return result

sol = Solution()
ans = sol.maxSlidingWindow(nums = [1,3,-1,-3,5,3,6,7], k = 1)
print(ans)