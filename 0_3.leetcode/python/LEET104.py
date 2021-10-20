from typing import *
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def maxDepth(root: TreeNode) -> int:
    if root is None:
        return 0
    depth = 0
    q = collections.deque()
    q.append(root)

    while q:
        depth += 1
        for _ in range(len(q)):
            cur_root = q.popleft()

            if cur_root.left:
                q.append(cur_root.left)
            if cur_root.right:
                q.append(cur_root.right)

    return depth

def solve():
    root = [3,9,20,None,None,15,7]
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

    res = maxDepth(nodes[0])
    print(res)

solve()