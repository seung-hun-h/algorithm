from typing import *

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost):
            return -1

        start, fuel = 0, 0
        for i in range(len(gas)):

            if gas[i] + fuel < cost[i]:
                start = i + 1 # 0 ~ i까지는 출발점이 될 수 없다.
                fuel = 0
            else:
                fuel += gas[i] - cost[i]

        return start

sol = Solution()
print(sol.canCompleteCircuit(gas = [2,3,4], cost = [3,4,3]))