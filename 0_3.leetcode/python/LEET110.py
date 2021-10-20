from typing import *
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def isBalanced(root: TreeNode) -> bool:
    def dfs(node):
        if not node:
            return 0
        
        left, right = dfs(node.left), dfs(node.right)

        if left == -1 or right == -1:
            return -1
        
        if abs(left - right) > 1:
            return -1
        
        return max(left, right) + 1
    
    return dfs(root) != -1    



def solve():
    root = build_tree([1,2,2,3,3,None,None,4,4])
    res = isBalanced(root)
    print(res)
def build_tree(root):
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
    return nodes[0]

def print_tree(root):
    q = collections.deque()
    q.append(root)
    res = []
    while q:
        for _ in range(len(q)):
            cur_root = q.popleft()
            res.append(cur_root.val)

            if cur_root.left:
                q.append(cur_root.left)
            if cur_root.right:
                q.append(cur_root.right)
    
    print(*res)

solve()