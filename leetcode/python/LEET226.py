from typing import *
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def invertTree(root: TreeNode) -> TreeNode:
    def dfs(node):
        if not node:
            return None
        node.left, node.right = dfs(node.right), dfs(node.left)
        return node

    return dfs(root)

def invertTree2(root: TreeNode) -> TreeNode:
    q = collections.deque([root])

    while q:
        node = q.popleft()

        if node:
            node.left, node.right = node.right, node.left
            
            q.append(node.left)
            q.append(node.right)

    return root

def invertTree3(root: TreeNode) -> TreeNode:
    stack = [root]
    while stack:
        node = stack.pop()

        if node:
            stack.append(node.left)
            stack.append(node.right)

            node.left, node.right = node.right, node.left
            
    return root

def solve():
    root = [4,2,7,1,3,6,9]
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

    res = invertTree(nodes[0])
    print_tree(res)
    
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