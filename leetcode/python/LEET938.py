from typing import *
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def rangeSumBST(root: TreeNode, low: int, high: int) -> int:
    def dfs(node: TreeNode):
        if not node:
            return 0
        
        if node.val > high:
            return dfs(node.left)
        
        if node.val < low:
            return dfs(node.right)
        
        return node.val + dfs(node.right) + dfs(node.left)

def solve():
    root = build_tree([15,9,21,7,13,19,23,5,None,11,None,17])
    res = rangeSumBST(root,low = 19, high = 21)
    print(res)

def build_tree(array: List[int]) -> TreeNode:
    if not array:
        return None

    root = TreeNode(array[0])
    q = collections.deque([root])
    index = 1

    while index < len(array):
        node = q.popleft()
        if array[index] is not None:
            left = TreeNode(array[index])
            node.left = left
            q.append(left)
        index += 1
        
        if index >= len(array): break

        if array[index] is not None:
            right = TreeNode(array[index])
            node.right = right
            q.append(right)
        index += 1

    return root

def print_tree(root):
    q = collections.deque([root])

    while q:
        node = q.popleft()
        if node:
            print(node.val, end=" ")
        else:
            print(None, end=" ")
            continue
        
        q.append(node.left)
        q.append(node.right)
    print()
solve()