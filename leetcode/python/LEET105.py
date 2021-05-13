from typing import *
import sys
import collections
sys.setrecursionlimit(10 ** 9)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def buildTree(preorder: List[int], inorder: List[int]) -> TreeNode:
    if inorder:
        index = inorder.index(preorder.pop(0))

        node = TreeNode(inorder[index])
        node.left = buildTree(preorder, inorder[:index])
        node.right = buildTree(preorder, inorder[index+1:])
        return node
def solve():
    res = buildTree(preorder = [3,9,20,15,7], inorder = [9,3,15,20,7])
    print_tree(res)

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