from sys import stdin
from collections import deque
readline = stdin.readline

class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

T = int(readline())
def solve():
    for _ in range(T):
        N = int(readline())
        preorder = deque(list(map(int, readline().split())))
        inorder = list(map(int, readline().split()))

        postorder_travel(preorder, inorder)
        print()


def postorder_travel(preorder, inorder):
    if preorder and inorder:
        node = preorder.popleft()

        index = inorder.index(node)
        postorder_travel(preorder, inorder[:index]) 
        postorder_travel(preorder, inorder[index+1:]) 
        print(node, end=' ')
solve()