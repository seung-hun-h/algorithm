from typing import *
import collections


class Solution:
    # 1 재귀
    def fib(self, n: int) -> int:
        if n <= 1:
            return n
        return self.fib(n-1) + self.fib(n-2)
    
    # 2 메모이제이션
    dp = collections.defaultdict(int)
    def fib(self, n: int) -> int:
        if n <= 1:
            return n

        if self.dp[n]:
            return self.dp[n]
        
        self.dp[n] = self.fib(n-1) + self.fib(n-2)
        return self.dp[n]

    # 3 타뷸레이션
    def fib(self, n: int) -> int:
        self.dp[0] = 0
        self.dp[1] = 1

        for i in range(2, n+1):
            self.dp[i] = self.dp[i-1] + self.dp[i-2]

        return self.dp[n]

    # 4 변수 두 개로 공간 절약
    def fib(self, n: int) -> int:
        x, y = 0, 1

        for _ in range(n):
            x, y = y, x + y

        return x