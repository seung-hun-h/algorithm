from typing import *
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def sortedArrayToBST(nums: List[int]) -> TreeNode:
    if not nums:
        return None
    
    mid = len(nums) // 2

    node = TreeNode(nums[mid])
    node.left = sortedArrayToBST(nums[:mid])
    node.right = sortedArrayToBST(nums[mid+1:])

    return node


def solve():
   sortedArrayToBST(nums = [-10,-3,0,5,9]) 
solve()