from typing import *

class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        def compute(left, right, op):
            return [eval(str(l)+op+str(r)) for l in left for r in right]
        
        if expression.isdigit():
            return [int(expression)]

        results = []
        for index, value in enumerate(expression):
            if value in '-+*':
                left = self.diffWaysToCompute(expression[:index])
                right = self.diffWaysToCompute(expression[index+1:])

                results.extend(compute(left, right, value))

        return results

sol = Solution()
print(sol.diffWaysToCompute("2-1-1"))