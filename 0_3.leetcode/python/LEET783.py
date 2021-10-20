from typing import *
import sys
import collections
sys.setrecursionlimit(10 ** 9)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

prev = -sys.maxsize
result = sys.maxsize
def minDiffInBST(root: TreeNode) -> int:
    global result, prev
    if root.left:
        minDiffInBST(root.left)

    result = min(result, root.val-prev)
    prev = root.val

    if root.right:
        minDiffInBST(root.right)
    
    return result

def minDiffInBST2(root: TreeNode) -> int:
    res,  prev = sys.maxsize, -sys.maxsize
    node = root
    stack = []
    while stack or node:
        while node:
            stack.append(node)
            node = node.left
        
        node = stack.pop()
        res = min(res, node.val-prev)
        prev = node.val

        node = node.right
    return res

def solve():
    root = build_tree([27,None,34,None,58,50,None,44])
    res = minDiffInBST(root)
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