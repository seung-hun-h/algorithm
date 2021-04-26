from typing import *
def dailyTemperatures(T: List[int]) -> List[int]:
    stack = []
    days = [0] * len(T)
    for i, t in enumerate(T):
        while stack and T[stack[-1]] < t:
            day= stack.pop()
            days[day] = i - day
        
        stack.append(i)
    return days