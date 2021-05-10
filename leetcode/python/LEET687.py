from typing import *

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

longest = 0
def longestUnivaluePath(root: TreeNode) -> int:
    def dfs(node):
        global longest
        if not node:
            return 0 
        
        left = dfs(node.left)
        right = dfs(node.right)

        if node.left and node.left.val == node.val:
            left += 1
        else:
            left = 0
        
        if node.right and node.right.val == node.val:
            right += 1
        else:
            right = 0
        
        longest = max(longest, left+right)
        return max(left, right)
    dfs(root)
    return longest
def solve():
    root = [1,4,5,4,4,5]
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

    res = longestUnivaluePath(nodes[0])
    print(res)

solve()