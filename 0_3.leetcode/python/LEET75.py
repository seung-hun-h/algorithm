from typing import *

def sortColors(nums: List[int]) -> None:
    red, white, blue = 0, 0, len(nums)

    while white < blue:
        if nums[white] < 1:
            nums[red], nums[white] = nums[white], nums[red]
            red += 1
            white += 1
        elif nums[white] > 1:
            blue -= 1
            nums[white], nums[blue] = nums[blue], nums[white]
        else:
            white += 1 

nums = [2, 0, 2, 1, 1, 0]
sortColors(nums)
print(nums)