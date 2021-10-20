from typing import *

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

longest = 0
def diameterOfBinaryTree(root: TreeNode) -> int:
    def dfs(node):
        global longest
        if node is None:
            return -1
        left = dfs(node.left)
        right = dfs(node.right)
        
        longest = max(longest, left+right+2)
        return 1 + max(left, right)

    dfs(root)
    return longest

def solve():
    root = [1,2,3,4,5]
    nodes = [TreeNode(r) if r is not None else None for r in root]
    
    for i in range(len(nodes)):
        node = nodes[i]
        left, right = i * 2 + 1, i * 2 + 2 

        if left < len(nodes):
            if nodes[left] is None: continue
            node.left = nodes[left]
        if right < len(nodes):
            if nodes[right] is None: continue
            node.right = nodes[right]

    res = diameterOfBinaryTree(nodes[0])
    print(res)

solve()