from typing import *

def maxProfit(prices: List[int]) -> int:
    cur = prices[0]
    _max = 0
    for i in range(1, len(prices)):
        if cur > prices[i]:
            cur = prices[i]
        else:
            if _max < prices[i] - cur:
                _max = prices[i] - cur
    return _max
result = maxProfit(prices = [7,1,5,3,6,4])