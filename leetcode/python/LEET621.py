from typing import *
import collections
import heapq

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counts = collections.Counter(tasks)
        pq = []
        for task in counts:
            heapq.heappush(pq, [-counts[task], task])

        step = 0
        while pq:
            temp = []
            for _ in range(n+1):
                step += 1
                if pq:
                    c, t = heapq.heappop(pq)
                    if c+1 < 0:
                        temp.append([c+1, t])

                if not temp:
                    break
            
            while temp:
                heapq.heappush(pq, temp.pop())

        return step

    def leastInterval2(self, tasks: List[str], n: int) -> int:
        counter = collections.Counter(tasks)
        result = 0

        while True:
            sub_count = 0
            for task, _ in counter.most_common(n+1):
                sub_count += 1
                result += 1

                # task 카운트 1 감소
                counter.subtrack(task)
                # 0이하 task 제거
                counter += collections.Counter()

            if not counter:
                break
            
            # idle
            result += n - sub_count + 1
        
        return result

sol = Solution()
print(sol.leastInterval(tasks = ["A","A","A","B","C","D"], n = 2
))