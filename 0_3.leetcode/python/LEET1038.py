from typing import *
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

val = 0
def bstToGst(root: TreeNode) -> TreeNode:
    global val
    if root is None:
        return 
    
    bstToGst(root.right)
    val += root.val
    root.val = val
    bstToGst(root.left)

    return root

def solve():
    root = build_tree([4,1,6,0,2,5,7,None,None,None,3,None,None,None,8])
    bstToGst(root)
    print_tree(root)

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