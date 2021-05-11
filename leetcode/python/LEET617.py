from typing import *
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def mergeTrees(root1: TreeNode, root2: TreeNode) -> TreeNode:
    if root1 and root2:
        node = TreeNode(root1.val +  root2.val)

        node.left = mergeTrees(root1.left, root2.left)
        node.right = mergeTrees(root1.right, root2.right)

        return node
    else:
        return root1 or root2

def mergeTrees2(root1, root2):
    if not(root1 and root2):
        return root1 or root2

    root = TreeNode(root1.val + root2.val)
    q = collections.deque([[root, root1, root2]])
    while q:
        r, t1, t2 = q.popleft()

        if t1.left and t2.left:
            node = TreeNode(t1.left.val + t2.left.val)
            q.append([node, t1.left, t2.left])
        else:
            node = t1.left or t2.left
        r.left = node

        
        if t1.right and t2.right:
            node = TreeNode(t1.right.val + t2.right.val)
            q.append([node, t1.right, t2.right])
        else:
            node = t1.right or t2.right
        r.right = node
    
    return root
def solve():
    root1 = build_tree([1,3,2,5])
    root2 = build_tree([2,1,3,None,4,None,7])

    res = mergeTrees(root1, root2)
    print_tree(res)

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