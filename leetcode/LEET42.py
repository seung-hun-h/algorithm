from typing import *

def trap(height: List[int]) -> int:
    left, right = 0, len(height) - 1
    left_max, right_max = height[left], height[right]

    volume = 0
    while left < right:
        left_max, right_max = max(left_max, height[left]), max(right_max, height[right])
        if left_max <= right_max:
            volume += left_max - height[left]
            left += 1
        else:
            volume += right_max - height[right]
            right -= 1
        
    return volume

def trap2(height: List[int]) -> int:
    volume = 0
    stack = []
    for i in range(len(height)):
        while stack and height[i] > height[stack[-1]]:
            top = stack.pop()

            if not stack:
                break

            distance = i - stack[-1] - 1
            water = min(height[i], height[stack[-1]]) - height[top]

            volume += distance * water
        
        stack.append(i)

    return volume

result = trap2(height = [4,2,0,3,2,5])
print(result)